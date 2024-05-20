package com.postech.adapter.driven.infra;

import com.postech.adapter.driver.api.entidade.PedidoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringPedidoRepositorio extends JpaRepository<PedidoEntidade, Long> {
}
