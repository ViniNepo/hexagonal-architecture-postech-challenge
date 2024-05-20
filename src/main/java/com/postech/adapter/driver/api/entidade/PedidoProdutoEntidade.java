package com.postech.adapter.driver.api.entidade;

import com.postech.core.domain.model.Pedido;
import com.postech.core.domain.model.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido_produto")
public class PedidoProdutoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PedidoEntidade pedido;

    @ManyToOne
    private ProdutoEntidade produto;

    private int quantidade;
}
