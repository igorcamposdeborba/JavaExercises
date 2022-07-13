package factory;
import model.IPhone;

// abstract class
public abstract class IPhoneFactory {

    public IPhone orderIphone(String level) { // pattern method
        IPhone device = null;

        device = createIphone(level);

        device.getHardware();
        device.assemble();
        device.certificate();
        device.pack();

        return device;
    }
    protected abstract IPhone createIphone(String level); // this is factory method: it's instantiate object in subclasses
}
