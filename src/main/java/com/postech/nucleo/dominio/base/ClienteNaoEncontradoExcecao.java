package com.postech.nucleo.dominio.base;

public class ClienteNaoEncontradoExcecao extends RuntimeException{

    public ClienteNaoEncontradoExcecao(String message) {
        super(message);
    }

    public ClienteNaoEncontradoExcecao(String message, Throwable cause) {
        super(message, cause);
    }
}
