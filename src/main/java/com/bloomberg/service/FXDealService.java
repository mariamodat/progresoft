package com.bloomberg.service;

import com.bloomberg.dto.FxDealDto;
import com.bloomberg.dto.FxDealResponse;

public interface FXDealService {


     FxDealResponse saveDeal(FxDealDto deal);
     FxDealDto findFxDealByUniqueId(String uniqueId);
}
