package GPhonePackage;

import java.awt.*;

public class GPhoneClassicCreater extends GPhoneCreater {
    public GPhoneClassicCreater(String newLineNumber) {
        super(newLineNumber);
    }

    @Override
    public GPhone Create(String String) {
        return new GPhoneClassic(String);
    }
}
