package com.example.glovo.converter;

import com.example.glovo.dto.ProductDto;
import com.example.glovo.model.Product;

public class ProductDtoConverter {

    public static Product toProduct(ProductDto productDto) {

        return Product.builder()
                .id(Product.generateId++)
                .name(productDto.getName())
                .cost(productDto.getCost())
                .build();
    }
}
