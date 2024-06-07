package com.bloomberg.controller;

import com.bloomberg.dto.FxDealDto;
import com.bloomberg.dto.FxDealResponse;
import com.bloomberg.service.FXDealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deals")
@RequiredArgsConstructor
public class BloombergController {

    private final FXDealService fxDealService;

    @GetMapping("")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping("/save")
    public ResponseEntity<FxDealResponse> saveNewFxDeal(@Valid @RequestBody FxDealDto fxDealDto) {
        return ResponseEntity.ok(fxDealService.saveDeal(fxDealDto));

    }

    @GetMapping("/{uniqueId}")
    public ResponseEntity<FxDealDto> getFxDealFromUniqueId( @PathVariable String uniqueId){
        return ResponseEntity.ok().body(fxDealService.findFxDealByUniqueId(uniqueId));
    }
}
