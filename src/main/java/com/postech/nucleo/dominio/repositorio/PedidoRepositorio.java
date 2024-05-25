package com.postech.nucleo.dominio.repositorio;

import com.postech.adaptador.condutor.api.entidade.PedidoEntidade;

import java.util.List;

public interface PedidoRepositorio {
    PedidoEntidade pegaPedidoPorId(Long id);
    PedidoEntidade salvaPedido(PedidoEntidade pedidoEntidade);
    void deletaPedido(PedidoEntidade pedidoEntidade);

    List<PedidoEntidade> pegaTodosProdutos();

}
