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
public class SystemEve {
    @JsonProperty(value = "constellation_id")
    private Integer constellationId;
    private String name;
    @JsonIgnore
    private List<Object> planets;
    @JsonIgnore
    private List<Object> position;
    @JsonProperty(value = "security_class")
    private String securityClass;
    @JsonProperty(value = "security_status")
    private Float securityStatus;
    @JsonProperty(value = "star_id")
    private Integer starId;
    @JsonIgnore
    private List<Object> stargates;
    private List<Integer> stations;
    private Integer system_id;
}
