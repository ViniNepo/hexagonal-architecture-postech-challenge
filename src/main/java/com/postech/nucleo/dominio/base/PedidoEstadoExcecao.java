package com.postech.nucleo.dominio.base;

public class PedidoEstadoExcecao extends RuntimeException{
    public PedidoEstadoExcecao(String message) {
        super(message);
    }

    public PedidoEstadoExcecao(String message, Throwable cause) {
        super(message, cause);
    }
}
