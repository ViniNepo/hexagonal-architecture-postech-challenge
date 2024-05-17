package com.postech.core.domain.repository;

import com.postech.core.domain.model.Cliente;

public interface ClienteRepository {
    Cliente buscarClientePorCPF(String cpf);
    Cliente cadastrarCliente(Cliente client);
    Boolean validarCliente(String cpf);
}
