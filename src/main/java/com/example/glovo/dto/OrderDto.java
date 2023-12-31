package com.example.glovo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {

    private List<ProductDto> products;

}
