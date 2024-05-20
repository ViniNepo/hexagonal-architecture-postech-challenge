package com.postech.core.application.services;

import com.postech.adapter.driver.api.entidade.ProdutoEntidade;
import com.postech.core.domain.model.Produto;
import com.postech.core.domain.enums.CategoriaProdutoEnum;

import java.util.List;

public interface ProdutoServico {
    Produto pegaProdutoPorId(Long id);
    List<Produto> pegaTodosProdutos();
    List<Produto> pegaProdutosPorCategoria(CategoriaProdutoEnum categoriaProduto);
    Produto criaNovoProduto(Produto produto);
    void atualizaProdutoPorId(Long id, Produto produto);
    void deletaProdutoPorId(Long id);
}
