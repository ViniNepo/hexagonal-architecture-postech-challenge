package com.postech.adapter.driver.api.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class ErrorDTO {

    private String status;
    private String error;
    private LocalDateTime timestamp;

    public ErrorDTO(String status, String error) {
        this.status = status;
        this.error = error;
        this.timestamp = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

}
