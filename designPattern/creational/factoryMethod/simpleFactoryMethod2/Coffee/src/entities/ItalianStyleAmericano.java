package entities;

import factory.Coffee;

public class ItalianStyleAmericano extends Coffee {


    @Override
    public void makeCoffee() {
        System.out.println("Preparing Italian Style Americano");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("Serving Italian Style Americano");
    }
}
