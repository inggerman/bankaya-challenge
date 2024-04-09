package com.bankaya.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VersionDetailDTO {

    private BigInteger rarity;

    private VersionDTO version;


}
