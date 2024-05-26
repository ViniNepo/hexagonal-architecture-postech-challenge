package com.postech.adaptador.condutor.api.controlador;

import com.postech.adaptador.condutor.api.dto.ApiRespostaDTO;
import com.postech.adaptador.condutor.api.dto.PedidoDTO;
import com.postech.adaptador.condutor.api.tratador.ResponseHandler;
import com.postech.nucleo.aplicacao.servico.PedidoServico;
import com.postech.nucleo.dominio.enums.EstadoPedidoEnum;
import com.postech.nucleo.dominio.modelo.Cliente;
import com.postech.nucleo.dominio.modelo.Pedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Pedido", description = "Recursos relacionados ao pedido")
@RestController
@RequestMapping("/pedido")
public class ControladorPedido {

    private final PedidoServico pedidoServico;

    @Autowired
    public ControladorPedido(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

    @Operation(summary = "Criar pedido", method = "POST", description = "Recurso para criar um pedido")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido criado com sucesso", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao criar pedido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @PostMapping(value = "pedido", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        return ResponseHandler.responseBuilder("Pedido criado com sucesso", HttpStatus.CREATED, pedidoServico.criaPedido(pedidoDTO));
    }

    @Operation(summary = "Pegar pedido", method = "GET", description = "Recurso para pegar um pedido")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido encontrado", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não foi encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @GetMapping(value = "/{id}/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> pegarPedidoPorId(@PathVariable Long id) {
        return ResponseHandler.responseBuilder("Pedido encontrado com sucesso", HttpStatus.OK, pedidoServico.pegaPedidoPorId(id));
    }


    @Operation(summary = "Notifica pedido", method = "GET", description = "Recurso para notificar um pedido")
    @ApiResponses(value = {
            @ApiResponse(description = "Notificação estado pedido realizada com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não foi encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @GetMapping(value = "/{id}/notificar-estado-pedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> notificarPedidoEstado(@PathVariable Long id) {
        return ResponseHandler.responseBuilder("Notificação estado pedido realizada com sucesso", HttpStatus.OK, pedidoServico.notificaEstadoPedido(id));
    }

    @Operation(summary = "Pegar todos pedidos", method = "GET", description = "Recurso para pegar todos pedidos")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido criado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
    })
    @GetMapping(value = "todos-pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> pegarTodosPedidos() {
        return ResponseHandler.responseBuilder("Pedidos encontrados", HttpStatus.OK, pedidoServico.pegaTodosProdutos());
    }

    @Operation(summary = "Atualizar estado do pedido", method = "PUT", description = "Recurso para atualizar estado de um pedido")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido criado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não foi encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar estado do pedido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @PutMapping(value = "/{id}/estado-pedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> atualizarEstadoPedidoPorId(@PathVariable Long id, @RequestParam EstadoPedidoEnum estado) {
        return ResponseHandler.responseBuilder("Estado do pedido atualizado com sucesso", HttpStatus.OK, pedidoServico.atualizaEstadoPedidoPorId(id, estado));

    }

    @Operation(summary = "Realiza o fake checkout do pedido", method = "PUT", description = "Recurso para realizar fake checkout do pedido")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido criado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "404", description = "Erro ao fazer o fake checkout do pedido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @PutMapping(value = "/{id}/fake-Checkout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> fakeCheckoutPorID(@PathVariable Long id) {
        pedidoServico.fakeCheckout(id);
        return ResponseHandler.responseBuilder("Pedido realizado com sucesso", HttpStatus.OK, null);
    }

    @Operation(summary = "Realiza deleção do pedido", method = "DELETE", description = "Recurso para deletar um pedido")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido deletado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "404", description = "Erro ao realizar exclusão do pedido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @DeleteMapping("/{id}/pedido")
    public ResponseEntity<Object> deletarPedido(@PathVariable Long id) {
        pedidoServico.deletarPedido(id);
        return ResponseHandler.responseBuilder("Pedido excluido com sucesso", HttpStatus.OK, null);
    }

}
