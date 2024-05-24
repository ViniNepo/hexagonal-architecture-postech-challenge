package com.postech.core.application.services;

import com.postech.adapter.driver.api.entidade.ClienteEntidade;
import com.postech.adapter.driver.api.mapper.MapeadorCliente;
import com.postech.core.domain.model.Cliente;
import com.postech.core.domain.repository.ClienteRepositorio;

public class ClienteServicoImpl implements ClienteServico {

    private final ClienteRepositorio clientRepository;

    public ClienteServicoImpl(ClienteRepositorio clienteRepository) {
        this.clientRepository = clienteRepository;
    }

    @Override
    public Cliente buscarClientePorCPF(String cpf) {
        ClienteEntidade clienteEntidade = clientRepository.buscarClientePorCPF(cpf);
        return MapeadorCliente.INSTANCIA.paraDominio(clienteEntidade);
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
