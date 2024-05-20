package com.postech.adapter.driver.api.controller;

import com.postech.adapter.driver.api.mapper.MapeadorCliente;
import com.postech.core.application.services.ClienteServico;
import com.postech.core.domain.model.Cliente;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ControladorCliente {

    private final ClienteServico clienteServico;

    @Autowired
    public ControladorCliente(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }

    @PostMapping(value = "cadastrarCliente", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteServico.cadastrarCliente(cliente);
    }

}
