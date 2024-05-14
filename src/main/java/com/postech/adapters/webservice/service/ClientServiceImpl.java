package com.postech.adapters.webservice.service;

import com.postech.core.application.repository.ClientRepository;
import com.postech.core.application.services.ClientService;
import com.postech.core.domain.model.Client;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client GetClientByCPF(String cpf) {
        return clientRepository.getClientByCPF(cpf);
    }

    @Override
    public void CreateClient(Client client) {
        clientRepository.createNewClient(client);
    }

    @Override
    public Boolean ValidateClient(String cpf) {
        return clientRepository.validateClientByCPF(cpf);
    }
}
