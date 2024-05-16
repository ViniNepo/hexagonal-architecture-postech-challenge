package com.postech.adapter.configurations;

import com.postech.adapter.service.ClientServiceImpl;
import com.postech.adapter.service.ProductServiceImpl;
import com.postech.adapter.service.OrderServiceImpl;
import com.postech.core.domain.repository.ClientRepository;
import com.postech.core.domain.repository.OrderRepository;
import com.postech.core.domain.repository.ProductRepository;
import com.postech.core.application.services.ClientService;
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
    ClientService clientService(final ClientRepository clientRepository) {
        return new ClientServiceImpl(clientRepository);
    }

    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }
}
