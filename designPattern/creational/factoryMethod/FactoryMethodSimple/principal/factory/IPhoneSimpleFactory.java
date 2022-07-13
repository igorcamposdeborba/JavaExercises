package factory;

import model.*;

// concrete class
public class IPhoneSimpleFactory {
    public static IPhone orderIPhone(String generation, String level) {
        IPhone device = null;

        if (generation.equals("X")) {
            if (level.equals("standard"))
                device = new IPhoneX();
            else if (level.equals("highEnd"))
                device = new IPhoneXSMax();
        } else if (generation.equals("11")) {
            if (level.equals("standard"))
                device = new IPhone11();
            else if (level.equals("highEnd"))
                device = new IPhone11Pro();
        }

        if (device != null) {
            device.getHardware();
            device.assemble();
            device.certificate();
            device.pack();
        }

        return device;

    }
}
