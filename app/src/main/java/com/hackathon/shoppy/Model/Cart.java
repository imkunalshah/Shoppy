package com.hackathon.shoppy.Model;

public class Cart {
    String pid , name , price, quantity , uid;

    public Cart() {
    }

    public Cart(String pid, String name, String price, String quantity, String uid) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
