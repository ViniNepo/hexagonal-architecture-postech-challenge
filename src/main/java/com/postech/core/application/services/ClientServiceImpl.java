package com.postech.core.application.services;

import com.postech.core.domain.repository.ClientRepository;
import com.postech.core.application.services.ClientService;
import com.postech.core.domain.model.Client;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClientByCPF(String cpf) {
        return clientRepository.getClientByCPF(cpf);
    }

    @Override
    public void createClient(Client client) {
        clientRepository.createNewClient(client);
    }

    @Override
    public Boolean validateClient(String cpf) {
        return clientRepository.validateClientByCPF(cpf);
    }
}
