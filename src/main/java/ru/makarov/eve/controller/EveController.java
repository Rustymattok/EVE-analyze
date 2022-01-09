package ru.makarov.eve.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.makarov.eve.model.eve.*;
import ru.makarov.eve.model.DataResultObject;
import ru.makarov.eve.service.EveService;
import ru.makarov.eve.utils.HttpUtils;

import java.util.List;

@RestController
@Slf4j
public class EveController {
    private final EveService eveService;

    @Autowired
    public EveController(EveService eveService) {
        this.eveService = eveService;
    }

    @GetMapping("/test/")
    public String getModels(){

        return "test method";
    }

    @GetMapping("/regions/")
    public ResponseEntity<DataResultObject<List<Integer>>> getIdsRegion(){

        return HttpUtils.ok(eveService.getIdsRegions());
    }

    @GetMapping("/systems/")
    public ResponseEntity<DataResultObject<List<Integer>>> getIdsSystems(){

        return HttpUtils.ok(eveService.getIdsSystems());
    }

    @GetMapping("/constellations/")
    public ResponseEntity<DataResultObject<List<Integer>>> getIdsConstellations(){

        return HttpUtils.ok(eveService.getIdsConstellations());
    }

    @GetMapping("/typeId/{id}")
    public ResponseEntity<DataResultObject<ItemEve>> getTypeInfoById(@PathVariable String id){

        return HttpUtils.ok(eveService.getInfoItem(id));
    }

    @GetMapping("/regions/{id}")
    public ResponseEntity<DataResultObject<RegionEve>> getRegionById(@PathVariable String id){

        return HttpUtils.ok(eveService.getRegionById(id));
    }

    @GetMapping("/constellations/{id}")
    public ResponseEntity<DataResultObject<ConstellationEve>> getConstellationById(@PathVariable String id){

        return HttpUtils.ok(eveService.getConstellationById(id));
    }

    @GetMapping("/systems/{id}")
    public ResponseEntity<DataResultObject<SystemEve>> getSystemEveById(@PathVariable String id){

        return HttpUtils.ok(eveService.getSystemById(id));
    }

    @GetMapping("/stations/{id}")
    public ResponseEntity<DataResultObject<StationEve>> getStationById(@PathVariable String id){

        return HttpUtils.ok(eveService.getStationById(id));
    }

}
