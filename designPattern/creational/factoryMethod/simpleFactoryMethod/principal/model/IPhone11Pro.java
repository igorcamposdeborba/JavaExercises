package model;

// concrete class
public class IPhone11Pro extends IPhone {
    @Override
    public void getHardware(){
        System.out.println("Hardware list");
        System.out.println("\t- 7.5in screen");
        System.out.println("\t- A14 chipset");
        System.out.println("\t- 8Gb RAM");
        System.out.println("\t-128Gb memory");
    }
}
