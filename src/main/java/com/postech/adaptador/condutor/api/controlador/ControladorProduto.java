package com.postech.adaptador.condutor.api.controlador;

import com.postech.adaptador.condutor.api.dto.ProdutoDTO;
import com.postech.adaptador.condutor.api.tratador.ResponseHandler;
import com.postech.nucleo.aplicacao.servico.ProdutoServico;
import com.postech.nucleo.dominio.enums.CategoriaProdutoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ControladorProduto {

    private final ProdutoServico produtoServico;

    @Autowired
    public ControladorProduto(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    @PostMapping(value = "criarProduto", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> criarProduto(@RequestBody ProdutoDTO produtoDTO){
        return ResponseHandler.responseBuilder("Produto criado com sucesso", HttpStatus.CREATED, produtoServico.criaNovoProduto(produtoDTO));
    }

    @PutMapping(value = "/atualizarProduto/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
        return ResponseHandler.responseBuilder("Produto atualizado com sucesso", HttpStatus.OK, produtoServico.atualizaProduto(id, produtoDTO));
    }

    @GetMapping(value = "/pegarTodosProdutos", produces =  MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> pegarTodosProdutos(){
        return ResponseHandler.responseBuilder("Produtos encontrados com sucesso", HttpStatus.OK, produtoServico.pegaTodosProdutos());
    }

    @GetMapping(value = "/pegarTodosPorCategoria", produces =  MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> pegarTodosPorCategoria(@RequestParam CategoriaProdutoEnum categoria){
        return ResponseHandler.responseBuilder("Produtos pela categoria informada encontrados com sucesso", HttpStatus.OK, produtoServico.pegaProdutosPorCategoria(categoria));
    }

    @GetMapping(value = "/pegarProduto/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> pegarProdutoPorID(@PathVariable Long id){
        return ResponseHandler.responseBuilder("Produto encontrado com sucesso", HttpStatus.OK,  produtoServico.pegaProdutoPorId(id));
    }

    @DeleteMapping(value = "/deletarProduto/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
    void deletarProdutoPorId(@PathVariable Long id){
        produtoServico.deletaProdutoPorId(id);
    }

}
