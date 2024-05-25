package com.postech.adaptador.condutor.api.mapeador;

import com.postech.adaptador.condutor.api.dto.ClienteDTO;
import com.postech.adaptador.condutor.api.entidade.ClienteEntidade;
import com.postech.nucleo.dominio.modelo.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapeadorCliente {

    MapeadorCliente INSTANCIA = Mappers.getMapper(MapeadorCliente.class);

    ClienteEntidade paraEntidade(Cliente cliente);

    Cliente paraDominio(ClienteEntidade clienteEntidade);

    Cliente paraDominio(ClienteDTO clienteDTO);

    ClienteDTO paraDTO(Cliente cliente);

    List<ClienteEntidade> paraEntidadeLista(List<Cliente> clientes);

    List<Cliente> paraDominioListaEntidade(List<ClienteEntidade> clientesEntidade);
    List<Cliente> paraDominioListaDTO(List<ClienteDTO> clientesDTO);
    List<ClienteDTO> paraDTOListaDominio(List<Cliente> clientes);
}
