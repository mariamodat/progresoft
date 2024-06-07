package com.bloomberg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
public class FxDealResponse {
    private String message;
    private HttpStatus statusCode;
}
