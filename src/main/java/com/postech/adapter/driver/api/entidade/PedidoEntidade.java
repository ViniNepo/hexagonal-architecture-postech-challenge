package com.postech.adapter.driver.api.entidade;

import com.postech.core.domain.enums.EstadoPedidoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class PedidoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntidade cliente;

    @Enumerated(EnumType.STRING)
    private EstadoPedidoEnum estado;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoProdutoEntidade> pedidosProdutos = new ArrayList<>();
}
