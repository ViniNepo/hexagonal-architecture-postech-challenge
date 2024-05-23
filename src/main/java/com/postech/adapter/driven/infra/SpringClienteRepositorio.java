package com.postech.adapter.driven.infra;

import com.postech.adapter.driver.api.entidade.ClienteEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringClienteRepositorio extends JpaRepository<ClienteEntidade, Long> {

    Optional<ClienteEntidade> getClienteEntidadeByCpf(String cpf);
}
