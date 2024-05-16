package com.postech.core.application.services;

import com.postech.core.domain.model.Product;
import com.postech.core.domain.enums.ProductCategoryEnum;

import java.util.List;

public interface ProductService {
    Product getProductByID(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(ProductCategoryEnum productCategory);
    void createNewProduct(Product product);
    void updateProductByID(Long id, Product product);
    void deleteProductByID(Long id);
}
