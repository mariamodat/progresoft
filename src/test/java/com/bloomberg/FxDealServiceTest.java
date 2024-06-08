package com.bloomberg;

import com.bloomberg.dto.FxDealDto;
import com.bloomberg.dto.FxDealResponse;
import com.bloomberg.exception.DuplicateFxDealException;
import com.bloomberg.repository.FxDealRepo;
import com.bloomberg.repository.FxDealRepoImpl;
import com.bloomberg.repository.jpa.FXDealRepository;
import com.bloomberg.service.FXDealService;
import com.bloomberg.service.FXDealServiceImpl;
import com.bloomberg.util.Util;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FxDealServiceTest {

    @Mock
    private FxDealRepo fxDealRepo;
    @Mock
    private FxDealRepoImpl fxDealRepoImpl;

    @Mock
    private FXDealRepository repository;

    @InjectMocks
    private FXDealServiceImpl fxDealServiceImpl;

    @Mock
    private FXDealService fxDealService;

    @Test
    public void saveDeal_Success() throws DuplicateFxDealException {
        FxDealDto dealDto = new FxDealDto("123456", "USD", "EUR", LocalDateTime.now(), BigDecimal.TEN);
        when(fxDealRepoImpl.findByUniqueId(dealDto.getDealUniqueId())).thenReturn(Optional.empty());

        FxDealResponse response = fxDealServiceImpl.saveDeal(dealDto);
        assertEquals("Deal with unique ID: 123456 has been created successfully!", response.getMessage());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(fxDealRepoImpl, times(1)).save(any());
    }

    @Test
    public void saveDeal_DuplicateDeal() {
        FxDealDto existingDealDto = new FxDealDto("123456", "USD", "EUR", LocalDateTime.now(), BigDecimal.TEN);
        when(fxDealRepoImpl.findByUniqueId(existingDealDto.getDealUniqueId())).thenReturn(Optional.of(Util.toEntity(existingDealDto)));

        assertThrows(DuplicateFxDealException.class, () -> fxDealServiceImpl.saveDeal(existingDealDto));
        verify(fxDealRepoImpl, never()).save(any());
    }
}
