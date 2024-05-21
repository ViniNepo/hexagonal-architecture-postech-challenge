package com.postech.core.domain.model;

import com.postech.core.domain.base.AgregacaoInterface;
import com.postech.core.domain.enums.EstadoPedidoEnum;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements AgregacaoInterface {

    private Long id;
    private Cliente cliente;
    private EstadoPedidoEnum estado;
    private List<PedidoProduto> pedidosProdutos;

    public Pedido(Long id, Cliente cliente, EstadoPedidoEnum estado, List<PedidoProduto> pedidosProdutos) {
        this.id = id;
        this.cliente = cliente;
        this.estado = estado;
        this.pedidosProdutos = pedidosProdutos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoPedidoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedidoEnum estado) {
        this.estado = estado;
    }

    public List<PedidoProduto> getPedidosProdutos() {
        return pedidosProdutos;
    }

    public void adicionaPedidoProduto(PedidoProduto pedidoProduto){
        if(pedidosProdutos == null){
            pedidosProdutos = new ArrayList<>();
        }
        pedidosProdutos.add(pedidoProduto);
    }
}
