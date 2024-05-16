package com.postech.core.application.services;

import com.postech.core.domain.repository.ClienteRepository;
import com.postech.core.domain.model.Cliente;

public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clientRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clientRepository = clienteRepository;
    }

    @Override
    public Cliente buscarClientePorCPF(String cpf) {
        return clientRepository.buscarClientePorCPF(cpf);
    }

    @Override
    public Cliente cadastrarCliente(Cliente client) {
        return clientRepository.cadastrarCliente(client);
    }

    @Override
    public Boolean validarCliente(String cpf) {
        return clientRepository.validarCliente(cpf);
    }
}
