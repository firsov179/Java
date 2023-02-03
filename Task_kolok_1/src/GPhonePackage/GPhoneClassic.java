package GPhonePackage;

import java.awt.*;

public class GPhoneClassic extends GPhone{
    public GPhoneClassic(String newGphoneString) {
        super(newGphoneString);
    }

    @Override
    public void getInfo() {
        System.out.printf("{Model='Classic', String='%s', Id='%d'}\n\n", getString(), getId());
    }
}
