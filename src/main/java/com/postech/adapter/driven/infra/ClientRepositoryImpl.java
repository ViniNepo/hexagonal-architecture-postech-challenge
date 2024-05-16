package com.postech.adapter.driven.infra;

import com.postech.core.domain.model.Client;
import com.postech.core.domain.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientRepositoryImpl implements ClientRepository {

    private final SpringClientRepository springClientRepository;

    public ClientRepositoryImpl(SpringClientRepository springClientRepository) {
        this.springClientRepository = springClientRepository;
    }

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
