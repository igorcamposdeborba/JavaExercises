package factory;

import model.IPhone;
import model.IPhone11;
import model.IPhone11Pro;

public class IPhone11ProFactory extends IPhoneFactory {

    @Override
    public IPhone createIphone(String level){

        if(level.equals("standard"))
            return new IPhone11();
        else if (level.equals("highEnd"))
            return new IPhone11Pro();
        else
            return null;
    }
}
