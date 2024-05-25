package com.postech.adaptador.conduzido.infra;

import com.postech.adaptador.condutor.api.entidade.PedidoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringPedidoRepositorio extends JpaRepository<PedidoEntidade, Long> {


}
