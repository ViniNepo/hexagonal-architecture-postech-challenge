package com.postech.adapter.driver.api.mapper;

import com.postech.adapter.driver.api.entidade.ClienteEntidade;
import com.postech.core.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapeadorCliente {

    MapeadorCliente INSTANCIA = Mappers.getMapper(MapeadorCliente.class);

    ClienteEntidade paraEntidade(Cliente cliente);

    Cliente paraDominio(ClienteEntidade clienteEntidade);

    List<ClienteEntidade> paraEntidadeLista(List<Cliente> clientes);

    List<Cliente> paraDominioLista(List<ClienteEntidade> clientesEntidade);
}
