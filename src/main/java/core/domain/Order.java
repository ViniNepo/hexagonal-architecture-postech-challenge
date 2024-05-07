package core.domain;

import core.domain.enums.OrderStatusEnum;

import java.util.List;

public class Order {

    private String ID;
    private String clientID;
    private OrderStatusEnum status;
    private List<Product> products;

    public Order(String ID, String clientID, OrderStatusEnum status) {
        this.ID = ID;
        this.clientID = clientID;
        this.status = status;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
