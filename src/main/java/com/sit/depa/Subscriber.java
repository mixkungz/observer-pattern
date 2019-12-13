package com.sit.depa;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {
    private String name;
    private List<String> inbox;

    public Subscriber() {
    }

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addInbox(String message){
        if(inbox == null) {
            inbox = new ArrayList<String>();
        }
        inbox.add(message);
    }
    public void getInBox() {
        if(inbox == null) {
            System.out.println("Empty inbox");
        } else {
            for (String message: inbox) {
                System.out.println(message);
            }
        }
    }

    public void subscribe(Product product){
        product.registerSubscriber(this);
    }
}
