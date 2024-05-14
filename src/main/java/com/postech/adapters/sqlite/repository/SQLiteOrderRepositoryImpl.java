package com.postech.adapters.sqlite.repository;

import com.postech.core.application.repository.OrderRepository;
import com.postech.core.domain.enums.OrderStatusEnum;
import com.postech.core.domain.model.Order;
import com.postech.core.domain.model.ProductCart;

public class SQLiteOrderRepositoryImpl implements OrderRepository {

    @Override
    public Order GerOrderByID(String id) {
        return null;
    }

    @Override
    public void CreateNewOrder(Order order) {

    }

    @Override
    public void AddProductCart(String orderID, ProductCart productCart) {

    }

    @Override
    public void UpdateOrderStatusByID(String orderID, OrderStatusEnum status) {

    }

    @Override
    public OrderStatusEnum NotifyOrderStatus(String orderID, OrderStatusEnum status) {
        return null;
    }

}
