package com.postech.adapter.driver.api.mapper;

import com.postech.adapter.driver.api.entidade.PedidoProdutoEntidade;
import com.postech.core.domain.model.PedidoProduto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(uses = MapeadorProduto.class)
public interface MapeadorPedidoProduto {
    MapeadorPedidoProduto INSTANCIA = Mappers.getMapper(MapeadorPedidoProduto.class);

    @Mapping(source = "produto", target = "produto")
    PedidoProdutoEntidade paraEntidade(PedidoProduto pedido);

    @Mapping(source = "produto", target = "produto")
    PedidoProduto paraDominio(PedidoProdutoEntidade pedidoProdutoEntidade);

    List<PedidoProdutoEntidade> paraEntidadeLista(List<PedidoProduto> pedidosProdutos);

    List<PedidoProduto> paraDominioLista(List<PedidoProdutoEntidade> pedidosProdutosEntidade);

}
