package com.postech.nucleo.dominio.base;

public class PedidoNaoEncontradoExcecao extends RuntimeException{

    public PedidoNaoEncontradoExcecao(String message) {
        super(message);
    }

    public PedidoNaoEncontradoExcecao(String message, Throwable cause) {
        super(message, cause);
    }
}
