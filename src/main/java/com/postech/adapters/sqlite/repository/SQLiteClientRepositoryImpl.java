package com.postech.adapters.sqlite.repository;

import com.postech.core.application.repository.ClientRepository;
import com.postech.core.domain.model.Client;

public class SQLiteClientRepositoryImpl implements ClientRepository {

    @Override
    public Client getClientByCPF(String cpf) {
        return null;
    }

    @Override
    public void createNewClient(Client client) {

    }

    @Override
    public Boolean validateClientByCPF(String cpf) {
        return null;
    }
}
