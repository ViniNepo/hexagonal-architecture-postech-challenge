package com.postech.core.domain.base;

import org.springframework.http.HttpStatus;

public class PedidoException   {

    private final String mensagem;

    private final Throwable throwable;

    private final HttpStatus httpEstado;

    public PedidoException(String mensagem, Throwable throwable, HttpStatus httpEstado) {
        this.mensagem = mensagem;
        this.throwable = throwable;
        this.httpEstado = httpEstado;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpEstado() {
        return httpEstado;
    }
}
