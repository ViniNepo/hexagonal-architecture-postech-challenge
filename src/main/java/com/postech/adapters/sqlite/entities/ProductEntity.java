package com.postech.adapters.sqlite.entities;

import com.postech.core.domain.enums.ProductCategoryEnum;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class ProductEntity {

    @Id
    private UUID id;
    private String name;
    private ProductCategoryEnum category;
    private Float price;

    public ProductEntity(UUID id, String name, ProductCategoryEnum category, Float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public ProductEntity() {
    }

//    public Product toProduct()
}

