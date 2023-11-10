package com.gen.TropicoBoards.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gen.TropicoBoards.Model.Orders;
import com.gen.TropicoBoards.Service.OrdersService;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = ordersService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long orderId) {
        Optional<Orders> orders = ordersService.getOrderById(orderId);
        if (orders.isPresent()) {
            return new ResponseEntity<>(orders.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Orders> createOrders(@RequestBody Orders orders) {
        Orders createdOrders = ordersService.createOrders(orders);
        return new ResponseEntity<>(createdOrders, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Orders> updateOrders(@PathVariable Long orderId, @RequestBody Orders orders) {
        Optional<Orders> existingOrders = ordersService.getOrderById(orderId);
        if (existingOrders.isPresent()) {
            orders.setId_orders(orderId);
            Orders updatedOrders = ordersService.updateOrders(orders);
            ordersService.updateOrders(orders);
            return new ResponseEntity<>(updatedOrders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrders(@PathVariable Long orderId) {
        ordersService.deleteOrders(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}