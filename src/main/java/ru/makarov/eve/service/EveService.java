package ru.makarov.eve.service;

import ru.makarov.eve.model.ItemEve;
import ru.makarov.eve.model.RegionEve;

import java.util.List;

public interface EveService {
    ItemEve getInfoItem(String idType);

    List<Integer> getIdRegions();

    RegionEve getRegionById(String idRegion);

}
