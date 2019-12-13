package com.sit.depa;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;
    private int stock;
    private List<Subscriber> subscribers;

    public Product() {
    }

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;

        String message = String.format("%s was change name to %s", oldName, this.name);
        notifyChangeToSubscriber(message);
    }

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;

        String message = String.format("%s was change price from %f to %f", this.name, oldPrice, this.price);
        notifyChangeToSubscriber(message);
    }

    public void setStock(int stock) {
        int oldStock = this.stock;
        this.stock = stock;

        String message = String.format("%s was change stock from %d to %d", this.name, oldStock, this.stock);
        if(this.stock == 0) {
            message = this.name + " is out of stock";
        }
        notifyChangeToSubscriber(message);
    }

    protected void notifyChangeToSubscriber(String message) {
        if(subscribers == null) {
            return;
        }
        for (Subscriber subscriber: subscribers) {
            subscriber.addInbox(message);
        }
    }

    public void registerSubscriber(Subscriber subscriber) {
        if(subscribers == null) {
            subscribers = new ArrayList<Subscriber>();
        }
        subscribers.add(subscriber);
    }
}
