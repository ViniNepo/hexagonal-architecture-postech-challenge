package com.postech.adapter.driven.infra;

import com.postech.adapter.driver.api.entidade.PedidoEntidade;
import com.postech.core.domain.enums.EstadoPedidoEnum;
import com.postech.core.domain.repository.PedidoRepositorio;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepositorioImpl implements PedidoRepositorio {

    private final SpringPedidoRepositorio springPedidoRepositorio;

    public PedidoRepositorioImpl(SpringPedidoRepositorio springPedidoRepositorio) {
        this.springPedidoRepositorio = springPedidoRepositorio;
    }

    @Override
    public PedidoEntidade pegaPedidoPorId(Long id) {
        return null;
    }

    @Override
    public void criaNovoPedido(PedidoEntidade pedidoEntidade) {

    }

    @Override
    public void deletaPedido(PedidoEntidade pedidoEntidade) {

    }

    @Override
    public void atualizaEstadoPedidoPorId(Long id, EstadoPedidoEnum estado) {

    }

    @Override
    public EstadoPedidoEnum notificaPedidoEstado(Long id) {
        return null;
    }
}
