package com.bloomberg.util;

import com.bloomberg.dto.FxDealDto;
import com.bloomberg.entity.FXDeal;

public class Util {

    public static FXDeal toEntity(FxDealDto dto){
        return FXDeal.builder()
                .dealAmount(dto.getDealAmount())
                .dealUniqueId(dto.getDealUniqueId())
                .dealTimestamp(dto.getDealTimestamp())
                .fromCurrencyIsoCode(dto.getFromCurrencyIsoCode())
                .toCurrencyIsoCode(dto.getToCurrencyIsoCode())
                .build();
    }
    public static FxDealDto toDto(FXDeal fxDeal){
        return FxDealDto.builder()
                .dealAmount(fxDeal.getDealAmount())
                .dealUniqueId(fxDeal.getDealUniqueId())
                .dealTimestamp(fxDeal.getDealTimestamp())
                .fromCurrencyIsoCode(fxDeal.getFromCurrencyIsoCode())
                .toCurrencyIsoCode(fxDeal.getToCurrencyIsoCode())
                .build();
    }
}
