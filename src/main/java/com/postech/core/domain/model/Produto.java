package com.postech.core.domain.model;

import com.postech.core.domain.enums.CategoriaProdutoEnum;

public class Produto {
    private Long id;

    private String nome;

    private String descricao;

    private CategoriaProdutoEnum categoria;

    private Double preco;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, CategoriaProdutoEnum categoria, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
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
