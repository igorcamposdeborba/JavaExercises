package entities;

import factory.Coffee;

public class ItalianStyleCapuccino extends Coffee {


    @Override
    public void makeCoffee() {
        System.out.println("Preparing Italian Style Capuccino");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("Serving Italian Style Capuccino");
    }
}
