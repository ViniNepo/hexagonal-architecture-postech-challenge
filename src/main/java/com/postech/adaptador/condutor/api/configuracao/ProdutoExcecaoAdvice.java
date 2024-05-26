package com.postech.adaptador.condutor.api.configuracao;

import com.postech.nucleo.dominio.base.ProdutoException;
import com.postech.nucleo.dominio.base.ProdutoNaoEncontradoExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProdutoExcecaoAdvice {

    @ExceptionHandler(value = {ProdutoNaoEncontradoExcecao.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<Object> produtoNaoEncontradoExcecaoHandler(ProdutoNaoEncontradoExcecao produtoNaoEncontradoExececao){

        ProdutoException produtoException = new ProdutoException(produtoNaoEncontradoExececao.getMessage(), produtoNaoEncontradoExececao.getCause(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(produtoException, HttpStatus.NOT_FOUND);

    }
}
