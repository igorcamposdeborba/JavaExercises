package principal;

import entities.ItalianStyleAmericano;
import entities.ItalianStyleCapuccino;
import enums.CoffeeType;
import factory.CoffeeShop;
import factory.SimpleItalianCoffeeFactory;

public class Program {
    public static void main (String [] args){
        CoffeeShop italianCoffeeShop = new SimpleItalianCoffeeFactory();
        italianCoffeeShop.orderCoffee(CoffeeType.capuccino);

        System.out.println();
        italianCoffeeShop.orderCoffee(CoffeeType.espresso);
    }
}
