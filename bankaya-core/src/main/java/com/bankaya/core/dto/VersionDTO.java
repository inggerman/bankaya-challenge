package com.bankaya.core.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VersionDTO {

    private String name;
    private String url;
}
