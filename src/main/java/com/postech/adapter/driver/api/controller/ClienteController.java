package com.postech.adapter.driver.api.controller;

import com.postech.adapter.driver.api.dto.ClienteDTO;
import com.postech.adapter.driver.api.mapper.ClienteMapper;
import com.postech.core.application.services.ClienteService;
import com.postech.core.domain.model.Cliente;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClienteController {

    private final ClienteService clienteService;

    private final ClienteMapper clienteMapper = Mappers.getMapper(ClienteMapper.class);

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO clientDTO) {
        Cliente cliente = clienteMapper.toEntity(clientDTO);
        Cliente clientSalvo = clienteService.cadastrarCliente(cliente);
        return clienteMapper.toDTO(clientSalvo);
    }

}
