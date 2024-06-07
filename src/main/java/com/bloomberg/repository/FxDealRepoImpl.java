package com.bloomberg.repository;

import com.bloomberg.dto.FxDealDto;
import com.bloomberg.entity.FXDeal;
import com.bloomberg.repository.jpa.FXDealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FxDealRepoImpl implements FxDealRepo{
     private final FXDealRepository repository;
    @Override
    public void save(FXDeal fxDeal) {
        repository.save(fxDeal);
    }

    @Override
    public Optional<FXDeal> findByUniqueId(String uniqueId) {
        return repository.findByDealUniqueId(uniqueId);
    }

//    private FXDeal toEntity(FxDealDto dto){
//        return FXDeal.builder()
//                .dealAmount(dto.getDealAmount())
//                .dealTimestamp(dto.getDealTimestamp())
//                .fromCurrencyIsoCode(dto.getFromCurrencyIsoCode())
//                .toCurrencyIsoCode(dto.getToCurrencyIsoCode())
//                .build();
//    }
//    private FxDealDto toDto(FXDeal fxDeal){
//        return FxDealDto.builder()
//                .dealAmount(fxDeal.getDealAmount())
//                .dealTimestamp(fxDeal.getDealTimestamp())
//                .fromCurrencyIsoCode(fxDeal.getFromCurrencyIsoCode())
//                .toCurrencyIsoCode(fxDeal.getToCurrencyIsoCode())
//                .build();
//    }
}
