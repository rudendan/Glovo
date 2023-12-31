package com.example.glovo.model;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    // id, date, cost, products

    private int id;
    private LocalDate date;
    private float cost;
    private List<Product> products;

    public static int generateId = 1000;

    public Order(int id, LocalDate date, List<Product> products) {
        this.id = id;
        this.date = date;
        this.products = products;

        for (Product product : products) {
            cost += product.getCost();
        }
    }
}
