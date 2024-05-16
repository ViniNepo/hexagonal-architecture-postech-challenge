package com.postech.adapter.driven.infra;

import com.postech.core.domain.enums.ProductCategoryEnum;
import com.postech.core.domain.model.Product;
import com.postech.core.domain.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final SpringProductRepository springProductRepository;

    public ProductRepositoryImpl(SpringProductRepository springProductRepository) {
        this.springProductRepository = springProductRepository;
    }

    @Override
    public Product getProductByID(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return springProductRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(ProductCategoryEnum productCategory) {
        return null;
    }

    @Override
    public void createNewProduct(Product product) {
        springProductRepository.save(product);
    }

    @Override
    public void updateProductByID(Long id, Product product) {

    }

    @Override
    public void deleteProductByID(Long id) {

    }
}
