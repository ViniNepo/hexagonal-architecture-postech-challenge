package com.postech.core.domain.base;

public class PedidoNaoEncontradoExececao extends RuntimeException{

    public PedidoNaoEncontradoExececao(String message) {
        super(message);
    }

    public PedidoNaoEncontradoExececao(String message, Throwable cause) {
        super(message, cause);
    }
}
