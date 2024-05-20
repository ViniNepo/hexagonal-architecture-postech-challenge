package com.postech.core.domain.repository;

import com.postech.adapter.driver.api.entidade.ClienteEntidade;
import com.postech.core.domain.model.Cliente;

public interface ClienteRepositorio {
    ClienteEntidade buscarClientePorCPF(String cpf);
    ClienteEntidade cadastrarCliente(ClienteEntidade clienteEntidade);
    Boolean validarCliente(String cpf);
}
