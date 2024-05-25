package com.postech.adaptador.conduzido.infra;

import com.postech.adaptador.condutor.api.entidade.PedidoEntidade;
import com.postech.nucleo.dominio.repositorio.PedidoRepositorio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoRepositorioImpl implements PedidoRepositorio {

    private final SpringPedidoRepositorio springPedidoRepositorio;

    public PedidoRepositorioImpl(SpringPedidoRepositorio springPedidoRepositorio) {
        this.springPedidoRepositorio = springPedidoRepositorio;
    }

    @Override
    public PedidoEntidade pegaPedidoPorId(Long id) {
        return springPedidoRepositorio.getReferenceById(id);
    }

    @Override
    public PedidoEntidade salvaPedido(PedidoEntidade pedidoEntidade) {
        return springPedidoRepositorio.save(pedidoEntidade);
    }

    @Override
    public void deletaPedido(PedidoEntidade pedidoEntidade) {
        springPedidoRepositorio.delete(pedidoEntidade);
    }

    @Override
    public List<PedidoEntidade> pegaTodosProdutos(){
        return springPedidoRepositorio.findAll();
    }

}
