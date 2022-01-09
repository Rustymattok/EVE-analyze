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
public class ConstellationEve {
    @JsonProperty(value = "constellation_id")
    private Integer constellation_id;
    private String name;
    @JsonIgnore
    private List<Object> position;
    @JsonProperty(value = "region_id")
    private Integer regionId;
    private List<Integer> systems;
}
