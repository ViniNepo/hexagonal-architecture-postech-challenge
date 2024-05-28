package com.postech.adaptador.condutor.api.controlador;

import com.postech.adaptador.condutor.api.dto.ErroDTO;
import com.postech.adaptador.condutor.api.dto.FakeCheckoutDTO;
import com.postech.adaptador.condutor.api.dto.entrada.PedidoEntradaDTO;
import com.postech.nucleo.aplicacao.servico.PedidoServico;
import com.postech.nucleo.dominio.enums.EstadoPedidoEnum;
import com.postech.nucleo.dominio.modelo.Pedido;
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

@Tag(name = "Pedido", description = "Recursos relacionados ao pedido")
@RestController
@RequestMapping("/pedidos")
public class ControladorPedido {

    private final PedidoServico pedidoServico;

    @Autowired
    public ControladorPedido(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

    @Operation(summary = "Criar pedido", method = "POST", description = "Recurso para criar um pedido")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido criado com sucesso", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoEntradaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao criar pedido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> criarPedido(@RequestBody PedidoEntradaDTO pedidoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoServico.criaPedido(pedidoDTO));
    }

    @Operation(summary = "Consultar pedido", method = "GET", description = "Recurso para consultar um pedido")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido encontrado", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao buscar pedido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não foi encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> consultarPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoServico.consultaPedidoPorId(id));
    }

    @Operation(summary = "Notifica pedido", method = "GET", description = "Recurso para notificar um pedido")
    @ApiResponses(value = {
            @ApiResponse(description = "Notificação estado pedido realizada com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao notificar estado do pedido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não foi encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
    })
    @GetMapping(value = "/{id}/notificar-estado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> notificarPedidoEstado(@PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoServico.notificaEstadoPedido(id));
    }

    @Operation(summary = "Consultar todos os pedidos", method = "GET", description = "Recurso para consultar todos os pedidos")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido criado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> consultarTodosPedidos() {
        return ResponseEntity.ok().body(pedidoServico.consultaTodosPedidos());
    }

    @Operation(summary = "Atualizar estado do pedido", method = "PATCH", description = "Recurso para atualizar estado de um pedido, o estado só pode ser alterado respeitando a seguinte ordem " +
            "[1 - PENDENTE_PAGAMENTO | 2 - PAGO | 3 - RECEBIDO | 4 - PREPARANDO | 5 - PRONTO | 6 - FINALIZADO | 7 - CANCELADO]. A partir de qualquer estado será possível alterar para o estado CANCELADO, com excessão do estado FINALIZADO.")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido criado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não foi encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar estado do pedido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
    })
    @PatchMapping(value = "/{id}/estado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> atualizarEstadoPedidoPorId(@PathVariable Long id, @RequestParam EstadoPedidoEnum estado) {
        return ResponseEntity.ok().body(pedidoServico.atualizaEstadoPedidoPorId(id, estado));
    }

    @Operation(summary = "Realiza o fake checkout do pedido", method = "PATCH", description = "Recurso para realizar fake checkout do pedido, atualiza o pedido de PENDENTE_PAGAMENTO para PAGO e depois RECEBIDO")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido criado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao fazer o fake checkout do pedido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
            @ApiResponse(responseCode = "404", description = "Algum recurso informado não foi encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
    })
    @PatchMapping(value = "/{id}/fake-checkout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> fakeCheckoutPorID(@PathVariable Long id) {
        pedidoServico.fakeCheckout(id);
        return ResponseEntity.ok().body(new FakeCheckoutDTO("Pedido realizado e enviado para a fila da cozinha"));
    }

    @Operation(summary = "Realiza deleção do pedido", method = "DELETE", description = "Recurso para deletar um pedido")
    @ApiResponses(value = {
            @ApiResponse(description = "Pedido deletado com sucesso", responseCode = "200", content = @Content),
            @ApiResponse(responseCode = "400", description = "Erro ao realizar exclusão do pedido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErroDTO.class))),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPedido(@PathVariable Long id) {
        pedidoServico.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

}
