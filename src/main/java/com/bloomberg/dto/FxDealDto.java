package com.bloomberg.dto;

import com.bloomberg.validation.ValidFXIsoCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FxDealDto {
    @NotNull
    @NotBlank
    private String dealUniqueId;
    @NotNull
    @ValidFXIsoCode
    private String fromCurrencyIsoCode;
    @NotNull
    @ValidFXIsoCode
    private String toCurrencyIsoCode;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dealTimestamp;
    @Positive
    private BigDecimal dealAmount;
}
