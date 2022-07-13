package principal;

import factory.IPhoneSimpleFactory;
import model.IPhone;

public class Program {

    public static void main (String [] args){

        System.out.println("Odering an iPhone");
        IPhone iPhone = IPhoneSimpleFactory.orderIPhone("X", "standard");
        System.out.println(iPhone);

        System.out.println("\n\nOdering an iPhone");
        IPhone iphone2 = IPhoneSimpleFactory.orderIPhone("11", "highEnd");
        System.out.println(iphone2);

    }
}
