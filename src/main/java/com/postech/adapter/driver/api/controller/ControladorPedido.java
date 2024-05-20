package com.postech.adapter.driver.api.controller;

import com.postech.core.application.services.PedidoServico;
import org.springframework.beans.factory.annotation.Autowired;
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
}
