package com.postech.adapter.driver.api.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class ErroDTO {

    private int status;
    private String erro;
    private LocalDateTime data;

    public ErroDTO(int status, String error) {
        this.status = status;
        this.erro = error;
        this.data = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

}
