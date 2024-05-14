package com.postech.core.application.repository;

import com.postech.core.domain.enums.OrderStatusEnum;
import com.postech.core.domain.model.Order;
import com.postech.core.domain.model.ProductCart;

public interface OrderRepository {
    Order GerOrderByID(String id);
    void CreateNewOrder(Order order);
    void AddProductCart(String orderID, ProductCart productCart);
    void UpdateOrderStatusByID(String orderID, OrderStatusEnum status);
    OrderStatusEnum NotifyOrderStatus(String orderID, OrderStatusEnum status);
}
