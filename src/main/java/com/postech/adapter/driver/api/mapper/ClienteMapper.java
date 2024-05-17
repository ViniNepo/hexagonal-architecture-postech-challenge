package com.postech.adapter.driver.api.mapper;

import com.postech.adapter.driver.api.dto.ClienteDTO;
import com.postech.core.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {

    public static final ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    public abstract Cliente toEntity(ClienteDTO clienteDTO);

    public abstract ClienteDTO toDTO(Cliente cliente);

}
