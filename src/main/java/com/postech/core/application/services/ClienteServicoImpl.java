package com.postech.core.application.services;

import com.postech.adapter.driver.api.entidade.ClienteEntidade;
import com.postech.adapter.driver.api.mapper.MapeadorCliente;
import com.postech.core.domain.repository.ClienteRepositorio;
import com.postech.core.domain.model.Cliente;

public class ClienteServicoImpl implements ClienteServico {

    private final ClienteRepositorio clientRepository;

    public ClienteServicoImpl(ClienteRepositorio clienteRepository) {
        this.clientRepository = clienteRepository;
    }

    @Override
    public Cliente buscarClientePorCPF(String cpf) {
        return MapeadorCliente.INSTANCIA.paraDominio(clientRepository.buscarClientePorCPF(cpf));
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        ClienteEntidade clienteEntidade = MapeadorCliente.INSTANCIA.paraEntidade(cliente);
        ClienteEntidade clienteSalvo  = clientRepository.cadastrarCliente(clienteEntidade);
        return MapeadorCliente.INSTANCIA.paraDominio(clienteSalvo);
    }

    @Override
    public Boolean validarCliente(String cpf) {
        return clientRepository.validarCliente(cpf);
    }
}
