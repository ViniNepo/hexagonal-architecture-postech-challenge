package com.postech.nucleo.aplicacao.servico;

import com.postech.adaptador.condutor.api.dto.PedidoDTO;
import com.postech.nucleo.dominio.enums.EstadoPedidoEnum;

import java.util.List;

public interface PedidoServico {
    PedidoDTO pegaPedidoPorId(Long id);
    PedidoDTO criaPedido(PedidoDTO pedidodto);
    PedidoDTO atualizaEstadoPedidoPorId(Long id, EstadoPedidoEnum estado);
    EstadoPedidoEnum notificaEstadoPedido(Long id);
    List<PedidoDTO> pegaTodosProdutos();
    void deletarPedido(Long id);
}
