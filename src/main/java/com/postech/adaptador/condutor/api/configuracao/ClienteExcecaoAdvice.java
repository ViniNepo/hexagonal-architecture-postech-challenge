package com.postech.adaptador.condutor.api.configuracao;

import com.postech.adaptador.condutor.api.tratador.ResponseHandler;
import com.postech.nucleo.dominio.base.ClienteException;
import com.postech.nucleo.dominio.base.ClienteNaoEncontradoExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClienteExcecaoAdvice {

    @ExceptionHandler(value = {ClienteNaoEncontradoExcecao.class})
    ResponseEntity<Object> clienteNaoEncontradoExcecaoHandler(ClienteException excecao){
        return ResponseHandler.responseBuilder(excecao.getMensagem(), HttpStatus.NOT_FOUND, null);
    }
}
