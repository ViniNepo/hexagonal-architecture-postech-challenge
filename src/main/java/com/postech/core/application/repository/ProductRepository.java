package com.postech.core.application.repository;

import com.postech.core.domain.model.Product;
import com.postech.core.domain.enums.ProductCategoryEnum;

import java.util.List;

public interface ProductRepository {
    Product GetProductByID(String id);
    List<Product> GetAllProducts();
    List<Product> GetProductsByCategory(ProductCategoryEnum productCategory);
    void CreateNewProduct(Product product);
    void UpdateProductByID(String id, Product product);
    void DeleteProductByID(String id);
}
