package com.postech.adaptador.condutor.api.configuracao;

import com.postech.adaptador.condutor.api.tratador.ResponseHandler;
import com.postech.nucleo.dominio.base.DominioExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DominioExcecaoAdvice {

    @ExceptionHandler(DominioExcecao.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Object> dominioExcecaoHandler(DominioExcecao excecao){
        return ResponseHandler.responseBuilder(excecao.getMessage(), HttpStatus.BAD_REQUEST, null);
    }
}
