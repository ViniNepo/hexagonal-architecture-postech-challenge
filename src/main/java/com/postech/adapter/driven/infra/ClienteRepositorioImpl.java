package com.postech.adapter.driven.infra;

import com.postech.adapter.driver.api.entidade.ClienteEntidade;
import com.postech.core.domain.repository.ClienteRepositorio;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepositorioImpl implements ClienteRepositorio {

    private final SpringClienteRepositorio springClienteRepositorio;

    public ClienteRepositorioImpl(SpringClienteRepositorio springClienteRepositorio) {
        this.springClienteRepositorio = springClienteRepositorio;
    }

    @Override
    public ClienteEntidade cadastrarCliente(ClienteEntidade clienteEntidade) {
        return springClienteRepositorio.save(clienteEntidade);
    }

    @Override
    public ClienteEntidade buscarClientePorCPF(String cpf) {
        return springClienteRepositorio.getClienteEntidadeByCpf(cpf);
    }

    @Override
    public Boolean validarCliente(String cpf) {
        return null;
    }
}
