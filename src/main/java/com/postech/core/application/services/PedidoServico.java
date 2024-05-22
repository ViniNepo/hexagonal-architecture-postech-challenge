package com.postech.core.application.services;

import com.postech.core.domain.enums.EstadoPedidoEnum;
import com.postech.core.domain.model.Pedido;

public interface PedidoServico {
    Pedido pegaPedidoPorId(Long id);
    void criaPedido(Pedido pedidoEntidade);
    void atualizaEstadoPedidoPorId(Long id, EstadoPedidoEnum estado);
    EstadoPedidoEnum notificaEstadoPedido(Long id);
}
