package com.example.glovo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    // id, date, cost, products

    private int id;
    private LocalDate date;
    private float cost;
    private List<Product> products;

    private static int generateId = 1000;

    public Order(List<Product> products) {
        this.id = generateId++;
        this.date = LocalDate.now();
        this.products = products;

        for (Product product : products) {
            cost += product.getCost();
        }
    }
}
