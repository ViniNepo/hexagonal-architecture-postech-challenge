package com.postech.adaptador.condutor.api.controlador;

import com.postech.adaptador.condutor.api.dto.ApiRespostaDTO;
import com.postech.adaptador.condutor.api.dto.ProdutoDTO;
import com.postech.adaptador.condutor.api.tratador.ResponseHandler;
import com.postech.nucleo.aplicacao.servico.ProdutoServico;
import com.postech.nucleo.dominio.enums.CategoriaProdutoEnum;
import com.postech.nucleo.dominio.modelo.Produto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ControladorProduto {

    private final ProdutoServico produtoServico;

    @Autowired
    public ControladorProduto(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    @Operation(summary = "Criar produto", method = "POST", description = "Recurso para criar um produto")
    @ApiResponses(value = {
            @ApiResponse(description = "Produto criado com sucesso", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao criar produto", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @PostMapping(value = "produto", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> criarProduto(@RequestBody ProdutoDTO produtoDTO){
        return ResponseHandler.responseBuilder("Produto criado com sucesso", HttpStatus.CREATED, produtoServico.criaNovoProduto(produtoDTO));
    }

    @Operation(summary = "Atualiza produto", method = "PUT", description = "Recurso para atualizar um produto")
    @ApiResponses(value = {
            @ApiResponse(description = "Produto atualizado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar produto", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
            @ApiResponse(responseCode = "404", description = "Produto informado não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @PutMapping(value = "/{id}/produto", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
        return ResponseHandler.responseBuilder("Produto atualizado com sucesso", HttpStatus.OK, produtoServico.atualizaProduto(id, produtoDTO));
    }


    @Operation(summary = "Pega todos os produtos", method = "GET", description = "Recurso para pegar todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(description = "Produtos encontrados com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produtos não foram encontrados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @GetMapping(value = "/{id}/todos-produto", produces =  MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> pegarTodosProdutos(){
        return ResponseHandler.responseBuilder("Produtos encontrados com sucesso", HttpStatus.OK, produtoServico.pegaTodosProdutos());
    }

    @Operation(summary = "Pega produto por categoria", method = "GET", description = "Recurso para pegar produto por categoria")
    @ApiResponses(value = {
            @ApiResponse(description = "Produtos pela categoria informada encontrados com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produtos não foram encontrados pela categoria informada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @GetMapping(value = "/produto-por-categoria", produces =  MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> pegarTodosPorCategoria(@RequestParam CategoriaProdutoEnum categoria){
        return ResponseHandler.responseBuilder("Produtos pela categoria informada encontrados com sucesso", HttpStatus.OK, produtoServico.pegaProdutosPorCategoria(categoria));
    }

    @Operation(summary = "Pega produto por ID", method = "GET", description = "Recurso para pegar produto por ID")
    @ApiResponses(value = {
            @ApiResponse(description = "Produto encontrado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produto não existe", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @GetMapping(value = "/{id}/produto", produces =  MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> pegarProdutoPorID(@PathVariable Long id){
        return ResponseHandler.responseBuilder("Produto encontrado com sucesso", HttpStatus.OK,  produtoServico.pegaProdutoPorId(id));
    }

    @Operation(summary = "Deleta produto por ID", method = "DELETE", description = "Recurso para pegar deletar um produto por ID")
    @ApiResponses(value = {
            @ApiResponse(description = "Produto deletado com sucesso", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produto não existe", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRespostaDTO.class))),
    })
    @DeleteMapping(value = "/{id}/produto")
    ResponseEntity<Object> deletarProdutoPorId(@PathVariable Long id){
        produtoServico.deletaProdutoPorId(id);
        return ResponseHandler.responseBuilder("Produto deletado com sucesso", HttpStatus.OK,  null);
    }

}
