package GPhonePackage;

import java.awt.*;

public class GPhonePremiumUltimaPlusXCreater extends GPhoneCreater{

    public GPhonePremiumUltimaPlusXCreater(String newCreaterName) {
        super(newCreaterName);
    }

    @Override
    public GPhone Create(String String) {
        return new GPhonePremiumUltimaPlusX(String);
    }
}
