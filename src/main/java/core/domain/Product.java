package core.domain;

import core.domain.enums.ProductCategoryEnum;

import java.math.BigDecimal;

public class Product {

    private String ID;
    private String name;
    private ProductCategoryEnum productType;
    private BigDecimal price;

    public Product(String ID, String name, ProductCategoryEnum productType, BigDecimal price) {
        this.ID = ID;
        this.name = name;
        this.productType = productType;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategoryEnum getProductType() {
        return productType;
    }

    public void setProductType(ProductCategoryEnum productType) {
        this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
