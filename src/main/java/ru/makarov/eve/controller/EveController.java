package ru.makarov.eve.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.makarov.eve.model.DataResultObject;
import ru.makarov.eve.model.ItemEve;
import ru.makarov.eve.service.EveService;
import ru.makarov.eve.utils.HttpUtils;

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

    @GetMapping("/typeId/{id}")
    public ResponseEntity<DataResultObject<ItemEve>> getTypeInfoById(@PathVariable String id){

        return HttpUtils.ok(eveService.getInfoItem(id));
    }

}
