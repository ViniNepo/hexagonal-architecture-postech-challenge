package com.postech.core.application.services;

import com.postech.core.domain.model.Client;

public interface ClientService {
    Client GetClientByCPF(String cpf);
    void CreateClient(Client client);
    Boolean ValidateClient(String cpf);
}
