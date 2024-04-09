package com.bankaya.core.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    API_UNAVAILABLE(0500,"API Unavailable");
    private Integer code;
    private String description;

}
