package com.example.glovo.dto;

import com.example.glovo.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {

    private List<Product> products;

}
