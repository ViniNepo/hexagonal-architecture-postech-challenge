package com.postech.nucleo.dominio.repositorio;

import com.postech.adaptador.condutor.api.entidade.ProdutoEntidade;
import com.postech.nucleo.dominio.enums.CategoriaProdutoEnum;

import java.util.List;

public interface ProdutoRepositorio {
    ProdutoEntidade pegaProdutoPorId(Long id);
    List<ProdutoEntidade> pegaTodosProdutos();
    List<ProdutoEntidade> pegaProdutosPorCategoria(CategoriaProdutoEnum produtoCategoria);
    ProdutoEntidade criaNovoProduto(ProdutoEntidade produto);
    ProdutoEntidade salvaProduto(ProdutoEntidade produto);
    void deletaProdutoPorId(Long id);
}
