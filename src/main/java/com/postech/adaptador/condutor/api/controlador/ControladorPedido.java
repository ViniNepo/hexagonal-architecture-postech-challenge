package com.postech.adaptador.condutor.api.controlador;

import com.postech.adaptador.condutor.api.dto.PedidoDTO;
import com.postech.adaptador.condutor.api.tratador.ResponseHandler;
import com.postech.nucleo.aplicacao.servico.PedidoServico;
import com.postech.nucleo.dominio.enums.EstadoPedidoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class ControladorPedido {

    private final PedidoServico pedidoServico;

    @Autowired
    public ControladorPedido(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

    @GetMapping(value = "/{id}/pegarPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> pegarPedidoPorId(@PathVariable Long id) {
        return ResponseHandler.responseBuilder("Pedido encontrado com sucesso", HttpStatus.OK, pedidoServico.pegaPedidoPorId(id));
    }

    @PutMapping(value = "/{id}/atualizarEstadoPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> atualizarEstadoPedidoPorId(@PathVariable Long id, @RequestParam EstadoPedidoEnum estado) {
        return ResponseHandler.responseBuilder("Estado do pedido atualizado com sucesso", HttpStatus.OK, pedidoServico.atualizaEstadoPedidoPorId(id, estado));

    }

    @GetMapping(value = "/{id}/notificarEstadoPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> notificarPedidoEstado(@PathVariable Long id) {
        return ResponseHandler.responseBuilder("Notificação estado pedido realizada com sucesso", HttpStatus.OK, pedidoServico.notificaEstadoPedido(id));
    }

    @PostMapping(value = "criarPedido", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        return ResponseHandler.responseBuilder("Pedido criado com sucesso", HttpStatus.CREATED, pedidoServico.criaPedido(pedidoDTO));
    }

    @GetMapping(value = "pegarTodosPedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> pegarTodosPedidos() {
        return ResponseHandler.responseBuilder("Pedidos encontrados em nossa base de dados", HttpStatus.OK, pedidoServico.pegaTodosProdutos());
    }

    @DeleteMapping("/{id}/deletarPedido")
    public ResponseEntity<Object> deletarPedido(@PathVariable Long id) {
        pedidoServico.deletarPedido(id);
        return ResponseHandler.responseBuilder("Pedido excluido com sucesso", HttpStatus.OK, null);
    }

}
