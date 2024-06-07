package com.bloomberg.repository;

import com.bloomberg.dto.FxDealDto;
import com.bloomberg.entity.FXDeal;

import java.util.Optional;

public interface FxDealRepo {
    void save(FXDeal fxDeal);
    Optional<FXDeal> findByUniqueId(String uniqueId);
}
