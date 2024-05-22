package com.postech.adapter.driver.api.controller;

import com.postech.core.application.services.PedidoServico;
import com.postech.core.domain.enums.EstadoPedidoEnum;
import com.postech.core.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class ControladorPedido {

    private final PedidoServico pedidoServico;

    @Autowired
    public ControladorPedido(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

    @PostMapping(value = "criaPedido", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void criaPedido(@RequestBody Pedido pedido) {
        pedidoServico.criaPedido(pedido);
    }

    @PostMapping(value = "pegaPedido", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void pegaPedidoPorId(@RequestParam Long id) {
        pedidoServico.pegaPedidoPorId(id);
    }

    @PostMapping(value = "atualizaEstado", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void atualizaEstadoPedidoPorId(@RequestParam Long id, @RequestParam EstadoPedidoEnum estado) {
        pedidoServico.atualizaEstadoPedidoPorId(id, estado);
    }

    @PostMapping(value = "notificaEstado", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void notificaPedidoEstado(@RequestParam Long id) {
        pedidoServico.notificaEstadoPedido(id);
    }
}
