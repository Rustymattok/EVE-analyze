package ru.makarov.eve.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import ru.makarov.eve.exception.CustomEveException;
import ru.makarov.eve.model.ItemEve;

@Slf4j
@Service
public class EveServiceImpl implements EveService {
    private RestTemplate restTemplate;

    //todo вынести в отдельный файл все методы и туда ссылаться
    private final String baseUrl = "https://esi.evetech.net/latest/";
    private final String TYPE = "/universe/types/";

    @Autowired
    public EveServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public ItemEve getInfoItem(String idType) {
        String url = baseUrl + TYPE + idType;

        return getCall(url, ItemEve.class);
    }

    private  <T, R extends T> T getCall(String url, Class<R> responseClass) {
        ResponseEntity<R> responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(url, responseClass);

        } catch (HttpStatusCodeException e) {
            throw new CustomEveException(e);
        }

        return responseEntity.getBody();
    }

}
