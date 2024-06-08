
package com.bloomberg.service;

import com.bloomberg.config.redis.RedisCacheTemplate;
import com.bloomberg.dto.FxDealDto;
import com.bloomberg.dto.FxDealResponse;
import com.bloomberg.entity.FXDeal;
import com.bloomberg.exception.DealNotFoundException;
import com.bloomberg.exception.DuplicateFxDealException;
import com.bloomberg.repository.FxDealRepoImpl;
import com.bloomberg.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FXDealServiceImpl implements FXDealService {

    private final FxDealRepoImpl fxDealRepo;
    private final RedisCacheTemplate cacheTemplate;


    @Override
    @Transactional
    public FxDealResponse saveDeal(FxDealDto deal) throws DuplicateFxDealException {

        Optional<FxDealDto> existingDeal = fxDealRepo.findByUniqueId(deal.getDealUniqueId()).map(Util::toDto);
        if (existingDeal.isPresent()) {
            throw new DuplicateFxDealException("Deal with unique ID " + deal.getDealUniqueId() + " already exists");
        }
        fxDealRepo.save(Util.toEntity(deal));
        return FxDealResponse.builder().message("Deal with unique ID: " + deal.getDealUniqueId() + " has been created successfully!")
                .statusCode(HttpStatus.CREATED).build();
    }

    @Override
    public FxDealDto findFxDealByUniqueId(String uniqueId) {
        FXDeal fxDeal = cacheTemplate.get(uniqueId);
        if (fxDeal == null) {
            log.info(String.format("getting the deal with unique id= %s from db!", uniqueId));
            fxDeal = fxDealRepo.findByUniqueId(uniqueId)
                    .orElseThrow(() -> new DealNotFoundException("Deal with unique id: " + uniqueId + " is not found!"));
            cacheTemplate.put(uniqueId, fxDeal);
        }
        return Util.toDto(fxDeal);
    }
}
