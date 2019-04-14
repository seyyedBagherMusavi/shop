package com.kahkeshan.entities;

public class OrderInfo {
    private Product product;
    private int quantity;

    public OrderInfo() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{" +
                "productName=" + product.getName() +
                ", quantity=" + quantity +
                '}';
    }
}
