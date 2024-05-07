package core.application.repository;

import core.domain.Client;

public interface ClientRepository {
    Client GetClientByCPF(String cpf);
    void CreateNewClient(Client client);
}
