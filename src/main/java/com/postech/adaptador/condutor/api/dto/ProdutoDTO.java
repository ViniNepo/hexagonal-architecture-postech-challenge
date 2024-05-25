package com.postech.adaptador.condutor.api.dto;

import com.postech.nucleo.dominio.enums.CategoriaProdutoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoDTO {

    private Long id;

    private String nome;

    private String descricao;

    private CategoriaProdutoEnum categoria;

    private Double preco;
}
