package com.codegym.model;

public class OrderDetail {
    private int id;
    private int customerId;
    private int amount;
    private float price;

    public OrderDetail() {
    }

    public OrderDetail(int id, int customerId, int amount, float price) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
