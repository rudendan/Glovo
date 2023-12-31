package com.example.glovo.controller;

import com.example.glovo.convertor.ProductDtoConverter;
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
        return orderService.get(id);
    }

    @PostMapping
    public Order create(@RequestBody OrderDto createOrder) {
        return orderService.create(createOrder.getProducts().stream().map(ProductDtoConverter::toProduct).toList());
    }

    @PatchMapping("/{id}")
    public Order add(@PathVariable int id, @RequestBody ProductDto product) {
        return orderService.addProduct(id, ProductDtoConverter.toProduct(product));
    }

    @DeleteMapping("/{id}")
    public List<Order> delete(@PathVariable int id) {
        return orderService.delete(id);
    }

    @DeleteMapping("/{orderId}/{productID}")
    public Order remove(@PathVariable int orderId, @PathVariable int productID) {
        return orderService.remove(orderId, productID);
    }

//    @Override
//    @DeleteMapping("/{orderId}/{name}")
//    public List<Order> remove(@PathVariable int orderId, String productId) {
//        return orderService.remove(orderId, productId);
//    }
}
