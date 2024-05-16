package com.postech.adapter.driven.infra;

import com.postech.core.domain.enums.OrderStatusEnum;
import com.postech.core.domain.model.Order;
import com.postech.core.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final SpringOrderRepository springOrderRepository;

    public OrderRepositoryImpl(SpringOrderRepository springOrderRepository) {
        this.springOrderRepository = springOrderRepository;
    }

    @Override
    public Order getOrderByID(Long id) {
        return null;
    }

    @Override
    public void createNewOrder(Order order) {

    }

    @Override
    public void deleteNewOrder(Order order) {

    }

    @Override
    public void updateOrderStatusByID(Long idOrder, OrderStatusEnum status) {

    }

    @Override
    public OrderStatusEnum notifyOrderStatus(Long idOrder) {
        return null;
    }
}
