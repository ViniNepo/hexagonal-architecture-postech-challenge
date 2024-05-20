package com.postech.adapter.driver.api.controller;

import com.postech.core.application.services.ProdutoServico;
import com.postech.core.domain.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ControladorProduto {

    private final ProdutoServico produtoServico;

    @Autowired
    public ControladorProduto(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    @PostMapping(value = "criarProdutos", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Produto criarProdutos(@RequestBody Produto produto){
        return produtoServico.criaNovoProduto(produto);
    }

    @GetMapping(value = "/pegaTodosProdutos", produces =  MediaType.APPLICATION_JSON_VALUE)
    List<Produto> pegaTodosProdutos(){
        return produtoServico.pegaTodosProdutos();
    }

}
