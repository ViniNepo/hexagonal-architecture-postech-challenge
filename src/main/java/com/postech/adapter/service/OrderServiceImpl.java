package com.postech.adapter.service;

import com.postech.core.domain.repository.OrderRepository;
import com.postech.core.application.services.OrderService;
import com.postech.core.domain.enums.OrderStatusEnum;
import com.postech.core.domain.model.Order;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrderByID(Long id) {
        return orderRepository.getOrderByID(id);
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.createNewOrder(order);
    }

    @Override
    public void updateOrderStatusByID(Long idOrder, OrderStatusEnum status) {
        orderRepository.updateOrderStatusByID(idOrder, status);
    }

    @Override
    public OrderStatusEnum notifyOrderStatus(Long idOrder) {
        return orderRepository.notifyOrderStatus(idOrder);
    }
}
