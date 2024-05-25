package com.postech.adaptador.condutor.api.dto;

import lombok.Data;

@Data
public class ApiRespostaDTO {

    private int estado;
    private String mensagem;
    private Object dados;

    public ApiRespostaDTO(int estado, String mensagem, Object dados) {
        this.estado = estado;
        this.mensagem = mensagem;
        this.dados = dados;
    }

}
