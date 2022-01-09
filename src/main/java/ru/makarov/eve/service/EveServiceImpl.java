package ru.makarov.eve.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import ru.makarov.eve.exception.CustomEveException;
import ru.makarov.eve.model.eve.*;

import java.util.List;

@Slf4j
@Service
public class EveServiceImpl implements EveService {
    private RestTemplate restTemplate;

    //todo вынести в отдельный файл все методы и туда ссылаться
    private final String baseUrl = "https://esi.evetech.net/latest/";
    private final String TYPE = "/universe/types/";
    private final String REGIONS = "/universe/regions/";
    private final String CONSTELLATION = "/universe/constellations/";
    private final String SYSTEMEVE = "/universe/systems/";
    private final String STATIONS = "/universe/stations/";

    @Autowired
    public EveServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public List<Integer> getIdsRegions() {
        String url = baseUrl + REGIONS;
        //todo посмотреть как изящней сделать
        List<Integer> listResponse =  getCall(url, List.class);

        return listResponse;
    }

    @Override
    public List<Integer> getIdsConstellations() {
        String url = baseUrl + CONSTELLATION;
        //todo посмотреть как изящней сделать
        List<Integer> listResponse =  getCall(url, List.class);

        return listResponse;
    }

    @Override
    public List<Integer> getIdsSystems() {
        String url = baseUrl + SYSTEMEVE;
        //todo посмотреть как изящней сделать
        List<Integer> listResponse =  getCall(url, List.class);

        return listResponse;
    }

    @Override
    public ItemEve getInfoItem(String idType) {
        String url = baseUrl + TYPE + idType;

        return getCall(url, ItemEve.class);
    }

    @Override
    public ConstellationEve getConstellationById(String idConstellation) {
        String url = baseUrl + CONSTELLATION + idConstellation;

        return getCall(url, ConstellationEve.class);
    }

    @Override
    public RegionEve getRegionById(String idRegion) {
        String url = baseUrl + REGIONS + idRegion;

        return getCall(url, RegionEve.class);
    }

    @Override
    public SystemEve getSystemById(String idSystem) {
        String url = baseUrl + SYSTEMEVE + idSystem;

        return getCall(url, SystemEve.class);
    }

    @Override
    public StationEve getStationById(String idStation) {
        String url = baseUrl + STATIONS + idStation;

        return getCall(url, StationEve.class);
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
