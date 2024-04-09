package com.bankaya.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbilityBaseDTO {

    @JsonProperty("ability")
    private AbilityDTO ability;

    @JsonProperty("is_hidden")
    private boolean isHidden;

    @JsonProperty("slot")
    private Integer slot;


}
