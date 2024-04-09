package com.bankaya.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokemonResponseDTO {

    private List<AbilityBaseDTO> abilities;

    @JsonProperty("base_experience")
    private String baseExperience;

    @JsonProperty("held_items")
    private List<HeldItemDTO> heldItemDTOS;

    private String id;

    private String name;

    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;




}
