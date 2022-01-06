package ru.makarov.eve.model.error;

import lombok.Builder;
import lombok.Getter;
import ru.makarov.eve.exception.ApiGlobalError;

import java.util.Collections;
import java.util.List;

@Builder
@Getter
public class ApiErrorsView {
    private List<ApiFieldError> fieldErrors;
    private List<ApiGlobalError> globalErrors;
    private String error;


    public static ApiErrorsView of(List<ApiFieldError> fieldErrors, ApiGlobalError globalErrors, String error ){

        return   ApiErrorsView.builder()
                .fieldErrors(Collections.emptyList())
                .globalErrors(Collections.singletonList(globalErrors))
                .error(error)
                .build();
    }
}
