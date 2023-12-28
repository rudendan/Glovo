package com.example.glovo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    // id, name, cost
    private Integer id;
    private String name;
    private float cost;
}
