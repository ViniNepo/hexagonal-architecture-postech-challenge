package com.postech.core.application.services;

import com.postech.adapter.driver.api.entidade.ProdutoEntidade;
import com.postech.adapter.driver.api.mapper.MapeadorProduto;
import com.postech.core.domain.repository.ProdutoRepositorio;
import com.postech.core.domain.model.Produto;
import com.postech.core.domain.enums.CategoriaProdutoEnum;

import java.util.List;

public class ProdutoServicoImpl implements ProdutoServico {

    private final ProdutoRepositorio productRepository;

    public ProdutoServicoImpl(ProdutoRepositorio productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Produto pegaProdutoPorId(Long id) {
        ProdutoEntidade produtoEntidade = productRepository.pegaProdutoPorId(id);
        return MapeadorProduto.INSTANCIA.paraDominio(produtoEntidade);
    }

    @Override
    public List<Produto> pegaTodosProdutos() {
        return MapeadorProduto.INSTANCIA.paraDominioLista(productRepository.pegaTodosProdutos());
    }

    @Override
    public List<Produto> pegaProdutosPorCategoria(CategoriaProdutoEnum categoriaProduto) {
        return MapeadorProduto.INSTANCIA.paraDominioLista(productRepository.pegaProdutosPorCategoria(categoriaProduto));
    }

    @Override
    public Produto criaNovoProduto(Produto produto) {
        ProdutoEntidade produtoSalvo = productRepository.criaNovoProduto(MapeadorProduto.INSTANCIA.paraEntidade(produto));
        return MapeadorProduto.INSTANCIA.paraDominio(produtoSalvo);
    }

    @Override
    public void atualizaProdutoPorId(Long id, Produto produto) {
        productRepository.atualizaProdutoPorId(id, MapeadorProduto.INSTANCIA.paraEntidade(produto));
    }

    @Override
    public void deletaProdutoPorId(Long id) {
        productRepository.deletaProdutoPorId(id);
    }
}
