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
public class ItemEve {
    private Float capacity;
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
    @JsonProperty(value = "icon_id")
    private Integer iconId;
    @JsonProperty(value = "market_group_id")
    private Integer marketGroupId;
    private Float mass;
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
