package com.postech.adapter.driver.api.controller;

import com.postech.core.domain.base.DominioExcecao;
import com.postech.core.domain.base.PedidoException;
import com.postech.core.domain.base.PedidoNaoEncontradoExececao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PedidoExcecaoAdvice {

    @ExceptionHandler(value = {PedidoNaoEncontradoExececao.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Object> pedidoNaoEncontradoExcecaoHandler(PedidoNaoEncontradoExececao pedidoNaoEncontradoExececao){

        PedidoException pedidoException = new PedidoException(pedidoNaoEncontradoExececao.getMessage(), pedidoNaoEncontradoExececao.getCause(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(pedidoException, HttpStatus.NOT_FOUND);

    }
}
