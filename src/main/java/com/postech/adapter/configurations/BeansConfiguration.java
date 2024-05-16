package com.postech.adapter.configurations;

import com.postech.core.application.services.ClienteServiceImpl;
import com.postech.core.application.services.ProductServiceImpl;
import com.postech.core.application.services.OrderServiceImpl;
import com.postech.core.domain.repository.ClienteRepository;
import com.postech.core.domain.repository.OrderRepository;
import com.postech.core.domain.repository.ProductRepository;
import com.postech.core.application.services.ClienteService;
import com.postech.core.application.services.OrderService;
import com.postech.core.application.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Boolean.class)
public class BeansConfiguration {


    @Bean
    ProductService productService(final ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    ClienteService clienteService(final ClienteRepository clienteRepository) {
        return new ClienteServiceImpl(clienteRepository);
    }

    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }
}
