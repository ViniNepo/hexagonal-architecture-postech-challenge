package com.postech.nucleo.dominio.base;

public class ProdutoNaoEncontradoExcecao extends RuntimeException{

    public ProdutoNaoEncontradoExcecao(String message) {
        super(message);
    }

    public ProdutoNaoEncontradoExcecao(String message, Throwable cause) {
        super(message, cause);
    }
}
