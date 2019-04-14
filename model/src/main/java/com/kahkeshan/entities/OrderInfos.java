package com.kahkeshan.entities;

import java.util.ArrayList;
import java.util.List;

public class OrderInfos {
    private List<OrderInfo> orderInfos = new ArrayList<>();
    private double price;

    public OrderInfos() {
    }

    public void addProduct(Product product, int quantity){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setProduct(product);
        orderInfo.setQuantity(quantity);
        orderInfos.add(orderInfo);
        price += (product.getPrice()*quantity);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderInfo> getOrderInfos() {
        return orderInfos;
    }
}
