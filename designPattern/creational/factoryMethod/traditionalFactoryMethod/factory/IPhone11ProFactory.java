package factory;

import model.IPhone11;

public class IPhone11ProFactory extends IPhoneFactory {

    @Override
    public IPhone11 createIphone(){
        return new IPhone11();
    }
}
