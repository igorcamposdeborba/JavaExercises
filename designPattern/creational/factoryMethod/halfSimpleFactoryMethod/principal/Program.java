package principal;

import factory.IPhone11ProFactory;
import factory.IPhoneFactory;
import factory.IPhoneXFactory;
import model.IPhone;

public class Program {
    public static void main (String [] args) {
        IPhoneFactory genXFactory = new IPhoneXFactory();
        IPhoneFactory gen11Factory = new IPhone11ProFactory();

        System.out.println("Ordering an iPhone");
        IPhone iphone = genXFactory.orderIphone("highEnd");
        System.out.println(iphone);

        System.out.println("\n\nOrdering an iPhone");
        IPhone iphone2 = gen11Factory.orderIphone("standard");
        System.out.println(iphone2);

    }
}
