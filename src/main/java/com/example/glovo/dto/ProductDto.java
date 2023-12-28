package com.example.glovo.dto;

import com.example.glovo.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private int orderId;
    private Product product;
}
