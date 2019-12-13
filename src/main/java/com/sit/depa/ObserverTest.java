package com.sit.depa;

public class ObserverTest {
    public static void main(String[] args) {
        Product cookie = new Product("Cookie", 10, 5);
        Product milk = new Product("Milk", 5, 10);
        Subscriber mix = new Customer("Mix");

        mix.subscribe(cookie);
        mix.subscribe(milk);

        mix.getInBox();
        cookie.setStock(4);
        System.out.println("========================");
        mix.getInBox();
        System.out.println("========================");
        cookie.setStock(0);
        milk.setPrice(10);
        mix.getInBox();
        System.out.println("========================");
    }
}
