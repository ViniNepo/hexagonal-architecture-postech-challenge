package com.postech.adapter.driver.api.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class ErroDTO {

    private String estado;
    private String erro;
    private LocalDateTime data;

    public ErroDTO(String status, String error) {
        this.estado = status;
        this.erro = error;
        this.data = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

}
