package com.postech.adapter.driven.infra;

import com.postech.core.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringClienteRepository extends JpaRepository<Cliente, Long> {
}
