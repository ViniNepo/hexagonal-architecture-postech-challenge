package com.postech.nucleo.dominio.base;

import org.springframework.http.HttpStatus;

public class ProdutoException {

    private final String mensagem;

    private final Throwable throwable;

    private final HttpStatus httpEstado;

    public ProdutoException(String mensagem, Throwable throwable, HttpStatus httpEstado) {
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