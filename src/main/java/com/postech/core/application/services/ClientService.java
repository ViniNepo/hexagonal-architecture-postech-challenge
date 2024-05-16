package com.postech.core.application.services;

import com.postech.core.domain.model.Client;

public interface ClientService {
    Client getClientByCPF(String cpf);
    void createClient(Client client);
    Boolean validateClient(String cpf);
}
