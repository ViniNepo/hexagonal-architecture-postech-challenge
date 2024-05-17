package com.postech.core.application.services;

import com.postech.core.domain.model.Cliente;

public interface ClienteService {
    Cliente buscarClientePorCPF(String cpf);
    Cliente cadastrarCliente(Cliente client);
    Boolean validarCliente(String cpf);
}
