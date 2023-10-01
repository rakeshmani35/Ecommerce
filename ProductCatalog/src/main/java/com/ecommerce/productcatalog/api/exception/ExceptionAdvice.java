package com.ecommerce.productcatalog.api.exception;

import com.ecommerce.productcatalog.api.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> productNotFound(Exception ex){
        ErrorResponseDto error = new ErrorResponseDto();
        error.setErrorMessage(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
}
