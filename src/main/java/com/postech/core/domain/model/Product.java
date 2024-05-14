package com.postech.core.domain.model;

import com.postech.core.domain.enums.ProductCategoryEnum;

public class Product {

    private String ID;
    private String name;
    private ProductCategoryEnum category;
    private Float price;

    public Product(String ID, String name, ProductCategoryEnum category, Float price) {
        this.ID = ID;
        this.name = name;
        this.category = category;
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

    public ProductCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryEnum category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
