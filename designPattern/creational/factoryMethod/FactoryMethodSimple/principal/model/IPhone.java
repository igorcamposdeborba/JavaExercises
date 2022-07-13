package model;

// abstract class
public abstract class IPhone {

    public abstract void getHardware(); // método abstrato

    public void assemble () {
        System.out.println("Assembling all the hardwares");
    }
    public void certificate(){
        System.out.println("Testing all the certificates");
    }
    public void pack(){
        System.out.println("Packing the device");
    }
}
