package com.postech.core.domain.base;

public class ProdutoNaoEncontradoExececao extends RuntimeException{

    public ProdutoNaoEncontradoExececao(String message) {
        super(message);
    }

    public ProdutoNaoEncontradoExececao(String message, Throwable cause) {
        super(message, cause);
    }
}
