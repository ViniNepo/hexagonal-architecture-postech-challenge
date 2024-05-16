package com.postech.core.domain.repository;

import com.postech.core.domain.enums.OrderStatusEnum;
import com.postech.core.domain.model.Order;

public interface OrderRepository {
    Order getOrderByID(Long id);
    void createNewOrder(Order order);
    void deleteNewOrder(Order order);
    void updateOrderStatusByID(Long idOrder, OrderStatusEnum status);
    OrderStatusEnum notifyOrderStatus(Long idOrder);
}
