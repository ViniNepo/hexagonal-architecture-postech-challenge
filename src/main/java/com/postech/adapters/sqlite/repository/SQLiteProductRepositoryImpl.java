package com.postech.adapters.sqlite.repository;

import com.postech.core.application.repository.ProductRepository;
import com.postech.core.domain.model.Product;
import com.postech.core.domain.enums.ProductCategoryEnum;

import java.util.List;

public class SQLiteProductRepositoryImpl implements ProductRepository {
    @Override
    public Product GetProductByID(String id) {
        return null;
    }

    @Override
    public List<Product> GetAllProducts() {
        return null;
    }

    @Override
    public List<Product> GetProductsByCategory(ProductCategoryEnum productCategory) {
        return null;
    }

    @Override
    public void CreateNewProduct(Product product) {

    }

    @Override
    public void UpdateProductByID(String id, Product product) {

    }

    @Override
    public void DeleteProductByID(String id) {

    }
}
