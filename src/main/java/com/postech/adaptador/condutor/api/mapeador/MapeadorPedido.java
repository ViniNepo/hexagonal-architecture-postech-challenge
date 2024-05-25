package com.postech.adaptador.condutor.api.mapeador;

import com.postech.adaptador.condutor.api.entidade.PedidoEntidade;
import com.postech.adaptador.condutor.api.dto.PedidoDTO;
import com.postech.nucleo.dominio.modelo.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = MapeadorPedidoProduto.class)
public interface MapeadorPedido {

    MapeadorPedido INSTANCIA = Mappers.getMapper(MapeadorPedido.class);

    PedidoEntidade paraEntidade(Pedido pedido);

    Pedido paraDominio(PedidoEntidade pedidoEntidade);

    PedidoDTO paraDto(Pedido pedido);

    Pedido paraDominio(PedidoDTO pedidoDTO);

    List<PedidoEntidade> paraEntidadeLista(List<Pedido> pedidos);

    List<Pedido> paraDominioListaEntidade(List<PedidoEntidade> pedidosEntidade);

    List<Pedido> paraDominioListaDTO(List<PedidoDTO> pedidosDTO);

    List<PedidoDTO> paraDTOLista(List<Pedido> pedidos);

}
