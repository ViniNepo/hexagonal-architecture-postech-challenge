package com.postech.adapter.driver.api.controller;

import com.postech.core.application.services.ProdutoServico;
import com.postech.core.domain.enums.CategoriaProdutoEnum;
import com.postech.core.domain.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "criaProdutos", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> criaProdutos(@RequestBody Produto produto){
        return ResponseHandler.responseBuilder("Produto criado com sucesso", HttpStatus.CREATED, produtoServico.criaNovoProduto(produto));
    }

    @PutMapping("atualizaProduto")
    ResponseEntity<Object> atualizaProduto(@RequestBody Produto produto){
        produtoServico.atualizaProduto(produto);
        return ResponseHandler.responseBuilder("Produto atualizado com sucesso", HttpStatus.OK, produto);
    }

    @GetMapping(value = "/pegaTodosProdutos", produces =  MediaType.APPLICATION_JSON_VALUE)
    List<Produto> pegaTodosProdutos(){
        return produtoServico.pegaTodosProdutos();
    }

    @GetMapping(value = "/pegaTodosPorCategoria", produces =  MediaType.APPLICATION_JSON_VALUE)
    List<Produto> pegaTodosPorCategoria(@RequestParam CategoriaProdutoEnum categoria){
        return produtoServico.pegaProdutosPorCategoria(categoria);
    }

    @GetMapping(value = "/pegaProdutoPorID", produces =  MediaType.APPLICATION_JSON_VALUE)
    Produto pegaProdutoPorID(@RequestParam Long id){
        return produtoServico.pegaProdutoPorId(id);
    }

    @DeleteMapping(value = "/deletaProdutoPorID", produces =  MediaType.APPLICATION_JSON_VALUE)
    void deletaProdutoPorId(@RequestParam Long id){
        produtoServico.deletaProdutoPorId(id);
    }

}
