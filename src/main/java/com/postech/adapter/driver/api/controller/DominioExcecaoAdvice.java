package com.postech.adapter.driver.api.controller;

import com.postech.core.domain.base.DominioExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DominioExcecaoAdvice {

    @ExceptionHandler(DominioExcecao.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String dominioExcecaoHandler(DominioExcecao excecao){
        return excecao.getMessage();
    }
}
