package model;

public class IPhoneX extends IPhone {

    @Override
    public void getHardware(){
        System.out.println("Hardware list");
        System.out.println("\t- 7.2in screen");
        System.out.println("\t- A14 chipset");
        System.out.println("\t- 5Gb RAM");
        System.out.println("\t-128Gb memory");
    }
}
