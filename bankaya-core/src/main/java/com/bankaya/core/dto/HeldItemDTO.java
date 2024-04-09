package com.bankaya.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeldItemDTO {

    @JsonProperty("item")
    private ItemDTO itemDTO;

    @JsonProperty("version_details")
    private List<VersionDetailDTO> versionDetailDTOS;

}
