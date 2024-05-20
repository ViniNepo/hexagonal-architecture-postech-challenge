package com.postech.adapter.driven.infra;

import com.postech.adapter.driver.api.entidade.ProdutoEntidade;
import com.postech.core.domain.enums.CategoriaProdutoEnum;
import com.postech.core.domain.repository.ProdutoRepositorio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoRepositorioImpl implements ProdutoRepositorio {

    private final SpringProdutoRepositorio springProdutoRepositorio;

    public ProdutoRepositorioImpl(SpringProdutoRepositorio springProdutoRepositorio) {
        this.springProdutoRepositorio = springProdutoRepositorio;
    }

    @Override
    public ProdutoEntidade pegaProdutoPorId(Long id) {
        return null;
    }

    @Override
    public List<ProdutoEntidade> pegaTodosProdutos() {
        return springProdutoRepositorio.findAll();
    }

    @Override
    public List<ProdutoEntidade> pegaProdutosPorCategoria(CategoriaProdutoEnum produtoCategoria) {
        return null;
    }

    @Override
    public ProdutoEntidade criaNovoProduto(ProdutoEntidade produtoEntidade) {
        return springProdutoRepositorio.save(produtoEntidade);
    }

    @Override
    public void atualizaProdutoPorId(Long id, ProdutoEntidade produtoEntidade) {

    }

    @Override
    public void deletaProdutoPorId(Long id) {

    }
}
