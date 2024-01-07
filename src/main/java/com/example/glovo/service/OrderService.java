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
        return orders.get(id);
    }

    public Order create(List<Product> products) {
        Order order = new Order(Order.generateId++, LocalDate.now(), new ArrayList<>(products));
        orders.put(order.getId(), order);
        return order;
    }

    public Order addProduct(int orderId, Product product) {
        Order order = orders.get(orderId);
        order.getProducts().add(product);
        order.setCost(order.getCost() + product.getCost());
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
                .findFirst().ifPresent(product -> {
                    order.setCost(order.getCost() - product.getCost());
                    order.getProducts().remove(product);
                });

        return order;
    }

    public Order update(int orderId, List<Product> products) {
        Order order = orders.get(orderId);
        order.setProducts(products);
        float cost = 0.0f;
        for (Product product : products)
            cost += product.getCost();
        order.setCost(cost);
        return orders.replace(orderId, order);
    }
}

