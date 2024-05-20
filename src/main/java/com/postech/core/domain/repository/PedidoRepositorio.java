package com.postech.core.domain.repository;

import com.postech.adapter.driver.api.entidade.PedidoEntidade;
import com.postech.core.domain.enums.EstadoPedidoEnum;

public interface PedidoRepositorio {
    PedidoEntidade pegaPedidoPorId(Long id);
    void criaNovoPedido(PedidoEntidade pedidoEntidade);
    void deletaPedido(PedidoEntidade pedidoEntidade);
    void atualizaEstadoPedidoPorId(Long id, EstadoPedidoEnum estado);
    EstadoPedidoEnum notificaPedidoEstado(Long id);
}
