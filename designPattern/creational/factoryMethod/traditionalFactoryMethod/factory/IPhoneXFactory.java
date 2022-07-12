package factory;

import model.IPhoneX;

public class IPhoneXFactory extends IPhoneFactory {

    public IPhoneX createIphone(){
        return new IPhoneX(); // instantiate Iphone
    } // high coupling
}
