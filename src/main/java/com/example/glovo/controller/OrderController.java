package com.example.glovo.controller;

import com.example.glovo.dto.ProductDto;
import com.example.glovo.dto.OrderDto;
import com.example.glovo.model.Order;
import com.example.glovo.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public List<Order> create(@RequestBody OrderDto createOrder) {
        return orderService.createOrder(createOrder.getProducts());
    }

    @PatchMapping
    public List<Order> add(@RequestBody ProductDto product) {
        return orderService.addProductToOrder(product.getOrderId(), product.getProduct());
    }

    @DeleteMapping("/{id}")
    public List<Order> delete(@PathVariable int id) {
        return orderService.removeOrder(id);
    }
}
