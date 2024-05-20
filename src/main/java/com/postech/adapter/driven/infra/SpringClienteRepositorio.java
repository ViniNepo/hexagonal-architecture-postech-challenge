package com.postech.adapter.driven.infra;

import com.postech.adapter.driver.api.entidade.ClienteEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringClienteRepositorio extends JpaRepository<ClienteEntidade, Long> {
}
