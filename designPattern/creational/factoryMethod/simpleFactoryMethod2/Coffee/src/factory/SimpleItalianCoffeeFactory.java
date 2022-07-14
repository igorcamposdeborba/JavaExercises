package factory;

import entities.ItalianCaffeConLatte;
import entities.ItalianStyleAmericano;
import entities.ItalianStyleCapuccino;
import entities.ItalianStyleEspresso;
import enums.CoffeeType;
import factory.Coffee;
import factory.CoffeeShop;

public class SimpleItalianCoffeeFactory extends CoffeeShop {

    public Coffee createCoffee(CoffeeType type){
        Coffee coffee = null;

        switch (type) {
            case americano:
                coffee = new ItalianStyleAmericano();
                break;
            case espresso:
                coffee = new ItalianStyleEspresso();
                break;
            case capuccino:
                coffee = new ItalianStyleCapuccino();
                break;
            case caffeConLatte:
                coffee = new ItalianCaffeConLatte();
                break;
        }
        return coffee;
    }
}
