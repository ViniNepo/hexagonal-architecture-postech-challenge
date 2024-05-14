package com.postech.adapters.webservice.service;

import com.postech.core.application.repository.ProductRepository;
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
    public Product GetProductByID(String id) {
        return productRepository.GetProductByID(id);
    }

    @Override
    public List<Product> GetAllProducts() {
        return productRepository.GetAllProducts();
    }

    @Override
    public List<Product> GetProductsByCategory(ProductCategoryEnum productCategory) {
        return productRepository.GetProductsByCategory(productCategory);
    }

    @Override
    public void CreateNewProduct(Product product) {
        productRepository.CreateNewProduct(product);
    }

    @Override
    public void UpdateProductByID(String id, Product product) {
        productRepository.UpdateProductByID(id, product);
    }

    @Override
    public void DeleteProductByID(String id) {
        productRepository.DeleteProductByID(id);
    }
}
