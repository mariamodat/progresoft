package com.bloomberg.exception.handler;

import com.bloomberg.dto.ErrorDto;
import com.bloomberg.exception.DealNotFoundException;
import com.bloomberg.exception.DuplicateFxDealException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(DuplicateFxDealException.class)
    public ResponseEntity<ErrorDto> handleDuplicateFxDealFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDto(HttpStatus.CONFLICT, e.getMessage()));

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DealNotFoundException.class)
    public ResponseEntity<ErrorDto> handleFxDealNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(HttpStatus.NOT_FOUND, e.getMessage()));

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    public ResponseEntity<ErrorDto> handle(Exception e) {
        return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage()));

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, ErrorDto>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, ErrorDto> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, new ErrorDto(HttpStatus.BAD_REQUEST, errorMessage));
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleIllegalArgumentException(IllegalArgumentException ex) {

        return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleGlobalException(Exception ex) {
        return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }
}
