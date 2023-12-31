package com.example.glovo.service;

import com.example.glovo.model.Order;
import com.example.glovo.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class OrderService {

    private Map<Integer, Order> orders = new HashMap<>();


    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    public Order get(int id) {

        return orders.values().stream()
                .filter(order -> order.getId() == id)
                .findFirst().orElseThrow();
    }

    public Order create(List<Product> products) {
        Order order = new Order(Order.generateId++, LocalDate.now(), new ArrayList<>(products));
        orders.put(order.getId(), order);
        return order;
    }

    public Order addProduct(int orderId, Product product) {
        Order order = orders.get(orderId);
        order.getProducts().add(product);
        return order;
    }

    public List<Order> delete(int orderId) {
        orders.remove(orderId);
        return new ArrayList<>(orders.values());
    }

    public Order remove(int orderId, int productId) {
        Order order = orders.get(orderId);
        order.getProducts().stream()
                .filter(product -> product.getId() == productId)
                .findFirst().ifPresent(product -> order.getProducts().remove(product));

        return order;
    }
}

