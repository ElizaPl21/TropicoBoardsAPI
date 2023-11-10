package com.gen.TropicoBoards.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.TropicoBoards.Model.Orders;
import com.gen.TropicoBoards.Repository.OrdersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders createOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    public Orders updateOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    public void deleteOrders(Long orderId) {
        ordersRepository.deleteById(orderId);
    }

    public Optional<Orders> getOrderById(Long orderId) {
        return ordersRepository.findById(orderId);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }
}