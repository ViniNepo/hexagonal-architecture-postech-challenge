package com.postech.adapter.driver.api.configuration;

import com.postech.adapter.driver.api.dto.ErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ExceptionHandlerConfiguration {

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroDTO notFoundException(HttpClientErrorException httpClientErrorException) {
        HttpStatusCode statusCode = httpClientErrorException.getStatusCode();
        return new ErroDTO(statusCode.value(), httpClientErrorException.getStatusText());
    }
}
