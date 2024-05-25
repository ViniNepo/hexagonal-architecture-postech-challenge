package com.postech.adaptador.condutor.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDTO {

    private Long id;

    private String nome;

    private String email;

    private String cpf;
}
