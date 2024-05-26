package com.postech.adaptador.condutor.api.configuracao;


import com.postech.adaptador.condutor.api.tratador.ResponseHandler;
import com.postech.nucleo.dominio.base.PedidoNaoEncontradoExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PedidoExcecaoAdvice {

    @ExceptionHandler(value = {PedidoNaoEncontradoExcecao.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<Object> pedidoNaoEncontradoExcecaoHandler(PedidoNaoEncontradoExcecao pedidoNaoEncontradoExececao){
        return ResponseHandler.responseBuilder(pedidoNaoEncontradoExececao.getMessage(), HttpStatus.NOT_FOUND, null);
    }
}
