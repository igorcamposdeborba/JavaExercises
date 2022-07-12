package factory;
import model.IPhone;

// abstract class
public abstract class IPhoneFactory {

    public IPhone orderIphone() {
        IPhone device = null;

        device = createIphone();

        device.getHardware();
        device.assemble();
        device.certificate();
        device.pack();

        return device;
    }
    protected abstract IPhone createIphone(); // this is factory method: it's instantiate object in subclasses
}
