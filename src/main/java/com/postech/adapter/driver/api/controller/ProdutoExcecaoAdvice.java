package com.postech.adapter.driver.api.controller;

import com.postech.core.domain.base.PedidoException;
import com.postech.core.domain.base.PedidoNaoEncontradoExececao;
import com.postech.core.domain.base.ProdutoException;
import com.postech.core.domain.base.ProdutoNaoEncontradoExececao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProdutoExcecaoAdvice {

    @ExceptionHandler(value = {ProdutoNaoEncontradoExececao.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Object> produtoNaoEncontradoExcecaoHandler(ProdutoNaoEncontradoExececao produtoNaoEncontradoExececao){

        ProdutoException produtoException = new ProdutoException(produtoNaoEncontradoExececao.getMessage(), produtoNaoEncontradoExececao.getCause(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(produtoException, HttpStatus.NOT_FOUND);

    }
}
