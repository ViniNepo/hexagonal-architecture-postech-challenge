package com.postech.adaptador.conduzido.infra;

import com.postech.adaptador.condutor.api.entidade.ClienteEntidade;
import com.postech.nucleo.dominio.base.ClienteNaoEncontradoExcecao;
import com.postech.nucleo.dominio.repositorio.ClienteRepositorio;
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
    public ClienteEntidade buscarClientePorId(Long id) {
        return springClienteRepositorio.getReferenceById(id);
    }

    @Override
    public ClienteEntidade buscarClientePorCPF(String cpf) {
        return springClienteRepositorio.getClienteEntidadeByCpf(cpf)
                .orElseThrow(() -> new ClienteNaoEncontradoExcecao("Cliente com cpf informado não encontrado"));
    }

}
