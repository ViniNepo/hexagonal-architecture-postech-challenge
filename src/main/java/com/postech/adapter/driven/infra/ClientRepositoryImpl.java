package com.postech.adapter.driven.infra;

import com.postech.core.domain.model.Cliente;
import com.postech.core.domain.repository.ClienteRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientRepositoryImpl implements ClienteRepository {

    private final SpringClienteRepository springClientRepository;

    public ClientRepositoryImpl(SpringClienteRepository springClientRepository) {
        this.springClientRepository = springClientRepository;
    }

    @Override
    public Cliente buscarClientePorCPF(String cpf) {
        return null;
    }

    @Override
    public Cliente cadastrarCliente(Cliente client) {
        return springClientRepository.save(client);
    }

    @Override
    public Boolean validarCliente(String cpf) {
        return null;
    }
}
