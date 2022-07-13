package model;

public class IPhoneXSMax extends IPhone {

    @Override
    public void getHardware(){
        System.out.println("Hardware list");
        System.out.println("\t- 7.4in screen");
        System.out.println("\t- A15 chipset");
        System.out.println("\t- 7Gb RAM");
        System.out.println("\t-512Gb memory");
    }
}
