package ru.makarov.eve.service;

import ru.makarov.eve.model.eve.*;

import java.util.List;

public interface EveService {
    List<Integer> getIdsRegions();

    List<Integer> getIdsConstellations();

    List<Integer> getIdsSystems();

    ItemEve getInfoItem(String idType);

    RegionEve getRegionById(String idRegion);

    ConstellationEve getConstellationById(String idConstellation);

    SystemEve getSystemById(String idSystem);

    StationEve getStationById(String idStation);

}
