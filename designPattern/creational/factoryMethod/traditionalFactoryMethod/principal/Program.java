package principal;

import factory.IPhone11ProFactory;
import factory.IPhoneFactory;
import factory.IPhoneXFactory;
import model.IPhone;

public class Program {
    public static void main (String [] args) {
        IPhoneFactory iphoneXFactory = new IPhoneXFactory();
        IPhoneFactory iphone11ProFactory = new IPhone11ProFactory();

        System.out.println("Ordering an iPhone X");
        IPhone iphone = iphoneXFactory.orderIphone();
        System.out.println(iphone);

        System.out.println("\n\nOrdering an iPhone 11 Pro");
        IPhone iphone2 = iphone11ProFactory.orderIphone();
        System.out.println(iphone2);

    }
}
