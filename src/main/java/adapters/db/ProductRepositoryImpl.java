package adapters.db;

import core.application.repository.OrderRepository;
import core.application.repository.ProductRepository;
import core.domain.Order;
import core.domain.Product;
import core.domain.enums.ProductCategoryEnum;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
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
