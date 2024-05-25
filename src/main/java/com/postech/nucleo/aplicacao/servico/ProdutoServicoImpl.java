package com.postech.nucleo.aplicacao.servico;

import com.postech.adaptador.condutor.api.dto.ProdutoDTO;
import com.postech.adaptador.condutor.api.entidade.ProdutoEntidade;
import com.postech.adaptador.condutor.api.mapeador.MapeadorProduto;
import com.postech.nucleo.dominio.base.ProdutoNaoEncontradoExcecao;
import com.postech.nucleo.dominio.repositorio.ProdutoRepositorio;
import com.postech.nucleo.dominio.modelo.Produto;
import com.postech.nucleo.dominio.enums.CategoriaProdutoEnum;

import java.util.List;

public class ProdutoServicoImpl implements ProdutoServico {

    private final ProdutoRepositorio productRepository;

    public ProdutoServicoImpl(ProdutoRepositorio productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProdutoDTO pegaProdutoPorId(Long id) {
        ProdutoEntidade produtoEntidade = productRepository.pegaProdutoPorId(id);

        if(produtoEntidade == null){
            throw new ProdutoNaoEncontradoExcecao("Produto informado não existe");
        }
        Produto produto = MapeadorProduto.INSTANCIA.paraDominio(produtoEntidade);
        return MapeadorProduto.INSTANCIA.paraDTO(produto);
    }

    @Override
    public List<ProdutoDTO> pegaTodosProdutos() {
        List<Produto> produtos = MapeadorProduto.INSTANCIA.paraDominioLista(productRepository.pegaTodosProdutos());
        return MapeadorProduto.INSTANCIA.paraDTOListaDominio(produtos);
    }

    @Override
    public List<ProdutoDTO> pegaProdutosPorCategoria(CategoriaProdutoEnum categoriaProduto) {
        List<Produto> produtos = MapeadorProduto.INSTANCIA.paraDominioLista(productRepository.pegaProdutosPorCategoria(categoriaProduto));
        return MapeadorProduto.INSTANCIA.paraDTOListaDominio(produtos);
    }

    @Override
    public ProdutoDTO criaNovoProduto(ProdutoDTO produtoDTO) {
        Produto produto = MapeadorProduto.INSTANCIA.paraDominio(produtoDTO);
        ProdutoEntidade produtoSalvo = productRepository.criaNovoProduto(MapeadorProduto.INSTANCIA.paraEntidade(produto));
        Produto produtoDominioSalvo = MapeadorProduto.INSTANCIA.paraDominio(produtoSalvo);
        return MapeadorProduto.INSTANCIA.paraDTO(produtoDominioSalvo);
    }

    @Override
    public ProdutoDTO atualizaProduto(Long id, ProdutoDTO produtoDTO) {
        this.pegaProdutoPorId(id);
        produtoDTO.setId(id);
        Produto produto = MapeadorProduto.INSTANCIA.paraDominio(produtoDTO);
        Produto produtoSalvo = MapeadorProduto.INSTANCIA.paraDominio(productRepository.salvaProduto(MapeadorProduto.INSTANCIA.paraEntidade(produto)));
        return MapeadorProduto.INSTANCIA.paraDTO(produtoSalvo);
    }

    @Override
    public void deletaProdutoPorId(Long id) {
        productRepository.deletaProdutoPorId(id);
    }
}
