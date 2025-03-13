package com.frete.listapedidos.model;

import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("product")
    private String product;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("total")
    private double total;

    public Order() {
    }

    public Order(String name, String product, int quantity, double total) {
        this.name = name;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
