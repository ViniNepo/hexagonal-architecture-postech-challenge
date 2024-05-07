package core.application.repository;

import core.domain.Order;

public interface OrderRepository {
    Order GerOrderByID(String id);
    void CreateNewOrder(Order order);
    void UpdateOrder(Order order);

}
