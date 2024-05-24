package com.postech.core.application.services;

import com.postech.core.domain.model.Cliente;

public interface ClienteServico {
    Cliente buscarClientePorCPF(String cpf);
    Cliente cadastrarCliente(Cliente cliente);
    Boolean validarCliente(String cpf);
}
