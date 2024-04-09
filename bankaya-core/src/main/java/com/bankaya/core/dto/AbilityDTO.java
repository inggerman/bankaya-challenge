package com.bankaya.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbilityDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;
}
