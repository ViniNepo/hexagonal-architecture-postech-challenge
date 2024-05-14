package com.postech.core.application.services;

import com.postech.core.domain.enums.OrderStatusEnum;
import com.postech.core.domain.model.Order;
import com.postech.core.domain.model.ProductCart;

public interface OrderService {
    Order GetOrderByID(String id);
    void CreateOrder(Order order);
    void AddProductCart(String orderID, ProductCart item);
    void UpdateOrderStatusByID(String orderID, OrderStatusEnum status);
    OrderStatusEnum NotifyOrderStatus(String orderID, OrderStatusEnum status);
}
