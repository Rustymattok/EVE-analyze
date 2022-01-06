package ru.makarov.eve.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket generalApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("EVE-API")
            .select()
            .paths(paths())
            .apis(RequestHandlerSelectors.basePackage("ru.makarov.eve.controller"))
            .build()
            .apiInfo(new ApiInfoBuilder().version("/api/v1").title("EVE API").build())
            .genericModelSubstitutes(Optional.class);
    }

    private Predicate<String> paths() {
        return regex(".*");
    }
}