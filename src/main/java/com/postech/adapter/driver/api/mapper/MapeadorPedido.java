package com.postech.adapter.driver.api.mapper;

import com.postech.adapter.driver.api.entidade.PedidoEntidade;
import com.postech.core.domain.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = MapeadorPedidoProduto.class)
public interface MapeadorPedido {

    MapeadorPedido INSTANCIA = Mappers.getMapper(MapeadorPedido.class);

    @Mapping(target = "pedidosProdutos", source = "pedidosProdutos")
    PedidoEntidade paraEntidade(Pedido pedido);

    @Mapping(target = "pedidosProdutos", source = "pedidosProdutos")
    Pedido paraDominio(PedidoEntidade pedidoEntidade);

    List<PedidoEntidade> paraEntidadeLista(List<Pedido> pedidos);

    List<Pedido> paraDominioLista(List<PedidoEntidade> pedidosEntidade);

}
