package ru.makarov.eve.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//todo Не под все Id работает - надо унифицировть модель
public class ItemEve {
    private Integer capacity;
    private String description;
    @JsonProperty(value = "dogma_attributes")
    @JsonIgnore
    private List<Object> dogmaAttributes;
    @JsonProperty(value = "dogma_effects")
    @JsonIgnore
    private List<Object> dogma_effects;
    @JsonProperty(value = "graphic_id")
    private Integer graphicId;
    @JsonProperty(value = "group_id")
    private Integer groupId;
    @JsonProperty(value = "market_group_id")
    private Integer marketGroupId;
    private Integer mass;
    private String name;
    @JsonProperty(value = "packaged_volume")
    private Integer packagedVolume;
    @JsonProperty(value = "portion_size")
    private Integer portionSize;
    private Boolean published;
    private Integer radius;
    @JsonProperty(value = "type_id")
    private Integer typeId;
    private Integer volume;
}
