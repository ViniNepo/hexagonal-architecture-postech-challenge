package com.postech.adapter.service;

import com.postech.core.domain.repository.ProductRepository;
import com.postech.core.application.services.ProductService;
import com.postech.core.domain.model.Product;
import com.postech.core.domain.enums.ProductCategoryEnum;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product getProductByID(Long id) {
        return productRepository.getProductByID(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(ProductCategoryEnum productCategory) {
        return productRepository.getProductsByCategory(productCategory);
    }

    @Override
    public void createNewProduct(Product product) {
        productRepository.createNewProduct(product);
    }

    @Override
    public void updateProductByID(Long id, Product product) {
        productRepository.updateProductByID(id, product);
    }

    @Override
    public void deleteProductByID(Long id) {
        productRepository.deleteProductByID(id);
    }
}
