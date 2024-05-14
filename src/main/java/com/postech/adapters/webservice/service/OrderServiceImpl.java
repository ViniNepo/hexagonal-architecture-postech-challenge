package com.postech.adapters.webservice.service;

import com.postech.core.application.repository.ClientRepository;
import com.postech.core.application.repository.OrderRepository;
import com.postech.core.application.services.ClientService;
import com.postech.core.application.services.OrderService;
import com.postech.core.domain.enums.OrderStatusEnum;
import com.postech.core.domain.model.Client;
import com.postech.core.domain.model.Order;
import com.postech.core.domain.model.ProductCart;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order GetOrderByID(String id) {
        return orderRepository.GerOrderByID(id);
    }

    @Override
    public void CreateOrder(Order order) {
        orderRepository.CreateNewOrder(order);
    }

    @Override
    public void AddProductCart(String orderID, ProductCart item) {
        orderRepository.AddProductCart(orderID, item);
    }

    @Override
    public void UpdateOrderStatusByID(String orderID, OrderStatusEnum status) {
        orderRepository.UpdateOrderStatusByID(orderID, status);
    }

    @Override
    public OrderStatusEnum NotifyOrderStatus(String orderID, OrderStatusEnum status) {
        return orderRepository.NotifyOrderStatus(orderID, status);
    }
}
