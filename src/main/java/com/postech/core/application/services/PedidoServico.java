package com.postech.core.application.services;

import com.postech.adapter.driver.api.entidade.PedidoEntidade;
import com.postech.core.domain.enums.EstadoPedidoEnum;
import com.postech.core.domain.model.Pedido;

public interface PedidoServico {
    Pedido pegaPedidoPorId(Long id);
    void criaPedido(Pedido pedidoEntidade);
    void atualizaPedidoEstadoPorId(Long id, EstadoPedidoEnum estado);
    EstadoPedidoEnum notificaPedidoEstado(Long id);
}
