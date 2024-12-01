package com.security.securityjwt.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResponseData {
    private String result;
    private String statusCode;
    private Object data;
}
