package com.postech.adapter.driver.api.controller;

import com.postech.adapter.driver.api.dto.ErroDTO;
import com.postech.core.application.services.ClienteServico;
import com.postech.core.domain.model.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cliente", description = "Recursos relacionados ao cliente")
@RestController
@RequestMapping("/cliente")
public class ControladorCliente {

    private final ClienteServico clienteServico;

    @Autowired
    public ControladorCliente(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }

    @Operation(summary = "Cadastrar cliente", method = "POST", description = "Recurso para cadastrar cliente")
    @ApiResponses(value = {
            @ApiResponse(description = "Cliente cadastrado com sucesso", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "400", description = "Error ao cadastrar cliente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteServico.cadastrarCliente(cliente);
    }

    @Operation(summary = "Buscar cliente", method = "POST", description = "Recurso para consultar cliente")
    @ApiResponses(value = {
            @ApiResponse(description = "Cliente encontrado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(description = "Error ao consultar cliente", responseCode = "400",  content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
            @ApiResponse(description = "Cliente não foi encontrado", responseCode = "404",  content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente consultarCliente(@RequestParam(value = "cpf", required = true) String cpf) {
        return clienteServico.buscarClientePorCPF(cpf);
    }
}
