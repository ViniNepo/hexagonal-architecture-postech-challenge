package com.postech.adaptador.condutor.api.dto;

import com.postech.nucleo.dominio.enums.EstadoPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {

    private Long id;
    private ClienteDTO cliente;
    private EstadoPedidoEnum estado;
    private List<PedidoProdutoDTO> pedidosProdutos;

}
