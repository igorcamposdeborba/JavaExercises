package entities;

import factory.Coffee;

public class ItalianStyleEspresso extends Coffee {


    @Override
    public void makeCoffee() {
        System.out.println("Preparing Italian Style Espresso");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("Serving Italian Style Espresso");
    }
}
