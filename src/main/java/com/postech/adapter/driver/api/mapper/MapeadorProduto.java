package com.postech.adapter.driver.api.mapper;

import com.postech.adapter.driver.api.entidade.ClienteEntidade;
import com.postech.adapter.driver.api.entidade.ProdutoEntidade;
import com.postech.core.domain.model.Cliente;
import com.postech.core.domain.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapeadorProduto {

    MapeadorProduto INSTANCIA = Mappers.getMapper(MapeadorProduto.class);

    ProdutoEntidade paraEntidade(Produto produto);

    Produto paraDominio(ProdutoEntidade produtoEntidade);

    List<ProdutoEntidade> paraEntidadeLista(List<Produto> produtos);

    List<Produto> paraDominioLista(List<ProdutoEntidade> produtosEntidade);
}
