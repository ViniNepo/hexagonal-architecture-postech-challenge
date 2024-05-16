package com.postech.core.domain.repository;

import com.postech.core.domain.model.Client;

public interface ClientRepository {
    Client getClientByCPF(String cpf);
    void createNewClient(Client client);
    Boolean validateClientByCPF(String cpf);
}
