package ru.makarov.eve.model.eve;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegionEve {
    private List<Integer> constellations;
    private String description;
    private String name;
    @JsonProperty(value = "region_id")
    private Integer regionId;
}
