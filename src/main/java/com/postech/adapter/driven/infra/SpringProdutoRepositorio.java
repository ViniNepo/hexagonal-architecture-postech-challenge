package com.postech.adapter.driven.infra;

import com.postech.adapter.driver.api.entidade.ProdutoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringProdutoRepositorio extends JpaRepository<ProdutoEntidade, Long> {
}
