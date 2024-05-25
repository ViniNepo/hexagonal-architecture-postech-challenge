package com.postech.adaptador.conduzido.infra;

import com.postech.adaptador.condutor.api.entidade.ProdutoEntidade;
import com.postech.nucleo.dominio.enums.CategoriaProdutoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringProdutoRepositorio extends JpaRepository<ProdutoEntidade, Long> {

    Optional<List<ProdutoEntidade>> getProdutoEntidadeByCategoria(CategoriaProdutoEnum categoria);

}
