package com.example.glovo.controller;

import com.example.glovo.converter.ProductDtoConverter;
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

    @GetMapping("/{id}")
    public Order get(@PathVariable int id) {
        return orderService.get(id);
    }

    @PostMapping
    public Order create(@RequestBody OrderDto order) {
        return orderService.create(order.getProducts().stream().map(ProductDtoConverter::toProduct).toList());
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable int id, @RequestBody OrderDto order) {
        return orderService.update(id, order.getProducts().stream().map(ProductDtoConverter::toProduct).toList());
    }

    @PatchMapping("/{id}")
    public Order add(@PathVariable int id, @RequestBody ProductDto product) {
        return orderService.addProduct(id, ProductDtoConverter.toProduct(product));
    }

    @DeleteMapping("/{id}")
    public List<Order> delete(@PathVariable int id) {
        return orderService.delete(id);
    }

    @DeleteMapping("/{id}/{productID}")
    public Order remove(@PathVariable int id, @PathVariable int productID) {
        return orderService.remove(id, productID);
    }
}
