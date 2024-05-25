package com.postech.nucleo.dominio.modelo;

import com.postech.nucleo.dominio.base.AgregacaoInterface;
import com.postech.nucleo.dominio.base.DominioExcecao;
import com.postech.nucleo.dominio.base.PreocupacaoAssercao;
import com.postech.nucleo.dominio.enums.CategoriaProdutoEnum;

public class Produto implements AgregacaoInterface {
    private Long id;

    private String nome;

    private String descricao;

    private CategoriaProdutoEnum categoria;

    private Double preco;


    public Produto(Long id, String nome, String descricao, CategoriaProdutoEnum categoria, Double preco) throws DominioExcecao {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
    }

    public void validaEntidade() throws DominioExcecao {
        PreocupacaoAssercao.validaArgumentoNaoVazio(nome, "O nome não pode estar vazio!");
        PreocupacaoAssercao.validaArgumentoNaoVazio(descricao, "O email não pode estar vazio!");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaProdutoEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProdutoEnum categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
