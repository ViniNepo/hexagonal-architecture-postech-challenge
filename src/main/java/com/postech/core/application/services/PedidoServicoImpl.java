package com.postech.core.application.services;

import com.postech.adapter.driver.api.entidade.PedidoEntidade;
import com.postech.adapter.driver.api.mapper.MapeadorPedido;
import com.postech.core.domain.repository.PedidoRepositorio;
import com.postech.core.domain.enums.EstadoPedidoEnum;
import com.postech.core.domain.model.Pedido;

public class PedidoServicoImpl implements PedidoServico {

    private final PedidoRepositorio pedidoRepositorio;

    public PedidoServicoImpl(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }
    @Override
    public Pedido pegaPedidoPorId(Long id) {
        return MapeadorPedido.INSTANCIA.paraDominio(pedidoRepositorio.pegaPedidoPorId(id));
    }

    @Override
    public void criaPedido(Pedido pedido) {
        pedidoRepositorio.criaNovoPedido(MapeadorPedido.INSTANCIA.paraEntidade(pedido));
    }

    @Override
    public void atualizaPedidoEstadoPorId(Long id, EstadoPedidoEnum estado) {
        pedidoRepositorio.atualizaEstadoPedidoPorId(id, estado);
    }

    @Override
    public EstadoPedidoEnum notificaPedidoEstado(Long id) {
        return pedidoRepositorio.notificaPedidoEstado(id);
    }
}
