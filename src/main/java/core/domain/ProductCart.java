package core.domain;

public class ProductCart {
    private String OrderID;
    private String ProductID;
    private int Quantity;

    public ProductCart(String orderID, String productID, int quantity) {
        OrderID = orderID;
        ProductID = productID;
        Quantity = quantity;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
