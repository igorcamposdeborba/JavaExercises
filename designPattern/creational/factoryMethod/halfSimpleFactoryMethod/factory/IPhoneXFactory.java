package factory;

import model.IPhone;
import model.IPhoneX;
import model.IPhoneXSMax;

public class IPhoneXFactory extends IPhoneFactory {

    public IPhone createIphone(String level){

        if (level.equals("standard"))
            return new IPhoneX(); // instantiate Iphone
        else if (level.equals("highEnd"))
            return new IPhoneXSMax();
        else
            return null;
    }
}
