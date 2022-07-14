package entities;

import factory.Coffee;

public class ItalianCaffeConLatte extends Coffee {

    @Override
    public void makeCoffee() {
        System.out.println("Preparing Italian Caffe con Latte");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("Serving Italian Caffe con Latte");
    }
}
