package com.postech.adaptador.conduzido.infra;

import com.postech.adaptador.condutor.api.entidade.ProdutoEntidade;
import com.postech.nucleo.dominio.base.ProdutoNaoEncontradoExcecao;
import com.postech.nucleo.dominio.enums.CategoriaProdutoEnum;
import com.postech.nucleo.dominio.repositorio.ProdutoRepositorio;
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
        return springProdutoRepositorio.getReferenceById(id);
    }

    @Override
    public List<ProdutoEntidade> pegaTodosProdutos() {
        return springProdutoRepositorio.findAll();
    }

    @Override
    public List<ProdutoEntidade> pegaProdutosPorCategoria(CategoriaProdutoEnum produtoCategoria) {
        return springProdutoRepositorio.getProdutoEntidadeByCategoria(produtoCategoria)
                .orElseThrow(() -> new ProdutoNaoEncontradoExcecao("Não foi encontrado produtos que correspondem a categoria informada"));
    }

    @Override
    public ProdutoEntidade criaNovoProduto(ProdutoEntidade produtoEntidade) {
        return springProdutoRepositorio.save(produtoEntidade);
    }

    @Override
    public ProdutoEntidade salvaProduto(ProdutoEntidade produtoEntidade) {
        return springProdutoRepositorio.save(produtoEntidade);
    }

    @Override
    public void deletaProdutoPorId(Long id) {
        springProdutoRepositorio.deleteById(id);
    }

}
