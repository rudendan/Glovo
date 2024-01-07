package com.example.glovo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {

    // id, name, cost
    private int id;
    private String name;
    private float cost;

    public static int generateId = 10;

    public Product(int id, String name, float cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}
