package com.postech.core.application.services;

import com.postech.core.domain.enums.OrderStatusEnum;
import com.postech.core.domain.model.Order;

public interface OrderService {
    Order getOrderByID(Long id);
    void createOrder(Order order);
    void updateOrderStatusByID(Long idOrder, OrderStatusEnum status);
    OrderStatusEnum notifyOrderStatus(Long idOrder);
}
