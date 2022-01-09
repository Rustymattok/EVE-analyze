package ru.makarov.eve.model.eve;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StationEve {
    @JsonProperty(value = "max_dockable_ship_volume")
    private Float maxDockableShipVolume;
    private String name;
    @JsonProperty(value = "office_rental_cost")
    private Float officeRentalCost;
    private Integer owner;
    @JsonIgnore
    private List<Object> position;
    @JsonProperty(value = "race_id")
    private Integer raceId;
    @JsonProperty(value = "reprocessing_efficiency")
    private Float reprocessingEfficiency;
    @JsonProperty(value = "reprocessing_stations_take")
    private Float reprocessingStationsTake;
    private List<String> services;
    @JsonProperty(value = "station_id")
    private Integer stationId;
    @JsonProperty(value = "system_id")
    private Integer systemId;
    @JsonProperty(value = "type_id")
    private Integer typeId;

    //todo нужна ли конвертация в енум тип?
}
