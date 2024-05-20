package com.postech.core.domain.repository;

import com.postech.adapter.driver.api.entidade.ProdutoEntidade;
import com.postech.core.domain.enums.CategoriaProdutoEnum;
import com.postech.core.domain.model.Produto;

import java.util.List;

public interface ProdutoRepositorio {
    ProdutoEntidade pegaProdutoPorId(Long id);
    List<ProdutoEntidade> pegaTodosProdutos();
    List<ProdutoEntidade> pegaProdutosPorCategoria(CategoriaProdutoEnum produtoCategoria);
    ProdutoEntidade criaNovoProduto(ProdutoEntidade produto);
    void atualizaProdutoPorId(Long id, ProdutoEntidade produto);
    void deletaProdutoPorId(Long id);
}
