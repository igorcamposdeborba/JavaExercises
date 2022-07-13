package model;

// concrete class
public class IPhone11 extends IPhone {
    @Override
    public void getHardware(){
        System.out.println("Hardware list");
        System.out.println("\t- 6.1in screen");
        System.out.println("\t- A13 chipset");
        System.out.println("\t- 4Gb RAM");
        System.out.println("\t-256Gb memory");
    }
}
