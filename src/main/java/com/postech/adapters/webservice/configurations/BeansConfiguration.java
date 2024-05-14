package com.postech.adapters.webservice.configurations;

import com.postech.adapters.sqlite.repository.SQLiteClientRepositoryImpl;
import com.postech.adapters.sqlite.repository.SQLiteOrderRepositoryImpl;
import com.postech.adapters.sqlite.repository.SQLiteProductRepositoryImpl;
import com.postech.adapters.webservice.service.ClientServiceImpl;
import com.postech.adapters.webservice.service.OrderServiceImpl;
import com.postech.core.application.repository.ClientRepository;
import com.postech.core.application.repository.OrderRepository;
import com.postech.core.application.repository.ProductRepository;
import com.postech.core.application.services.ClientService;
import com.postech.core.application.services.OrderService;
import com.postech.core.application.services.ProductService;
import com.postech.adapters.webservice.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Boolean.class)
public class BeansConfiguration {

    @Bean
    ProductRepository productRepository() {
        return new SQLiteProductRepositoryImpl();
    }

    @Bean
    OrderRepository orderRepository() {
        return new SQLiteOrderRepositoryImpl();
    }

    @Bean
    ClientRepository clientRepository() {
        return new SQLiteClientRepositoryImpl();
    }

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
