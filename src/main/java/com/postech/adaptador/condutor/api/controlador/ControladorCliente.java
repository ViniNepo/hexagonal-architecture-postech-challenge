package com.postech.adaptador.condutor.api.controlador;

import com.postech.adaptador.condutor.api.dto.ApiRespostaDTO;
import com.postech.adaptador.condutor.api.dto.ClienteDTO;
import com.postech.adaptador.condutor.api.tratador.ResponseHandler;
import com.postech.nucleo.aplicacao.servico.ClienteServico;
import com.postech.nucleo.dominio.modelo.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar cliente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @PostMapping( value = "cadastrarCliente", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> cadastrarCliente(@RequestBody ClienteDTO cliente) {
        return ResponseHandler.responseBuilder("Cliente cadastrado com sucesso", HttpStatus.OK, clienteServico.cadastrarCliente(cliente));
    }

    @Operation(summary = "Buscar cliente", method = "GET", description = "Recurso para consultar cliente")
    @ApiResponses(value = {
            @ApiResponse(description = "Cliente encontrado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(description = "Erro ao consultar cliente", responseCode = "400",  content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
            @ApiResponse(description = "Cliente não foi encontrado", responseCode = "404",  content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @GetMapping(value = "/consultarClientePorCPF", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> consultarCliente(@RequestParam(value = "cpf") String cpf) {
        return ResponseHandler.responseBuilder("Cliente encontrado com sucesso", HttpStatus.OK, clienteServico.buscarClientePorCPF(cpf));
    }

}
