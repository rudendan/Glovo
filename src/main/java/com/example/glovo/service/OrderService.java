package com.example.glovo.service;

import com.example.glovo.model.Order;
import com.example.glovo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public OrderService() {
        orders.add(new Order(new ArrayList<>(List.of(
                    new Product(1001, "SomeProduct1", 1001.0F),
                    new Product(1002, "SomeProduct2", 1002.0F)))));
        orders.add(new Order(new ArrayList<>(List.of(
                            new Product(1003, "SomeProduct3", 1004.0F),
                            new Product(1004, "SomeProduct4", 1004.0F)))));
    }

    public List<Order> getAll() {
        return orders;
    }

    public Order getOrderById(int id) {

        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst().orElse(null);
    }

    public List<Order> createOrder(List<Product> products) {
        orders.add(new Order(products));
        return orders;
    }

    public List<Order> addProductToOrder(int orderId, Product product) {
        orders.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst()
                .ifPresent(order -> {
                    order.getProducts().add(product);
                    order.setCost(order.getCost() + product.getCost());
                });

        return orders;
    }

    public List<Order> removeOrder(int orderId) {
        orders.removeIf(order -> order.getId() == orderId);
        return orders;
    }

    public void removeProductInOrder(int orderId, int productId) {

    }
}

