package com.postech.nucleo.dominio.modelo;

import com.postech.nucleo.dominio.base.AgregacaoInterface;
import com.postech.nucleo.dominio.base.DominioExcecao;
import com.postech.nucleo.dominio.base.PreocupacaoAssercao;

import java.util.Optional;

public class Cliente implements AgregacaoInterface {

    private Long id;

    private String nome;

    private String email;

    private CPF cpf;

    public Cliente(Long id, String nome, String email, CPF cpf) throws DominioExcecao {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;

        validaEntidade();
        cpf.validar();
    }

    public void validaEntidade() throws DominioExcecao {
        PreocupacaoAssercao.validaArgumentoNaoVazio(nome, "O nome não pode estar vazio!");
        PreocupacaoAssercao.validaArgumentoNaoVazio(email, "O email não pode estar vazio!");
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CPF getCPF() {
        return cpf;
    }

    public void setCPF(CPF cpf) {
        this.cpf = cpf;
    }
    
    public String getNumeroCpf() {
        return Optional.ofNullable(cpf)
                .map(CPF::getNumero)
                .orElse(null);
    }

    public void setNumeroCpf(String numeroCpf) {
        this.cpf = new CPF(numeroCpf);
    }
}
