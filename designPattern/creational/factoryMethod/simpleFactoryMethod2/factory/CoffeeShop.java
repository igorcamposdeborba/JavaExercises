package factory;

import enums.CoffeeType;

public abstract class CoffeeShop {

    public Coffee orderCoffee(CoffeeType type) { // enum ensures the input is correct and without NullPointerException. But handle the exception to select list of input
        Coffee coffee = createCoffee(type);

        coffee.makeCoffee(); // implemented methods into subclasses
        coffee.pourIntoCup();

        System.out.println("Here's yours coffee");
        return coffee; // show
    }

    protected abstract Coffee createCoffee(CoffeeType type);
}
