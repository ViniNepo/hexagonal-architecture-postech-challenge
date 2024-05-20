package com.postech.adapter.configurations;

import com.postech.core.application.services.ClienteServicoImpl;
import com.postech.core.application.services.ProdutoServicoImpl;
import com.postech.core.application.services.PedidoServicoImpl;
import com.postech.core.domain.repository.ClienteRepositorio;
import com.postech.core.domain.repository.PedidoRepositorio;
import com.postech.core.domain.repository.ProdutoRepositorio;
import com.postech.core.application.services.ClienteServico;
import com.postech.core.application.services.PedidoServico;
import com.postech.core.application.services.ProdutoServico;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Boolean.class)
public class BeansConfiguration {


    @Bean
    ProdutoServico produtoServico(final ProdutoRepositorio produtoRepositorio) {
        return new ProdutoServicoImpl(produtoRepositorio);
    }

    @Bean
    ClienteServico clienteServico(final ClienteRepositorio clienteRepositorio) {
        return new ClienteServicoImpl(clienteRepositorio);
    }

    @Bean
    PedidoServico pedidoServico(final PedidoRepositorio pedidoRepositorio) {
        return new PedidoServicoImpl(pedidoRepositorio);
    }
}
