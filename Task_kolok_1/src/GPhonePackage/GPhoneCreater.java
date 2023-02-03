package GPhonePackage;

import java.awt.*;

public abstract class GPhoneCreater {
    private String name;
    
    public String getNumber() {
        return name;
    }

    public GPhoneCreater(String newLineNumber)
    {
        name = newLineNumber;
    }
    
    // фабричный метод
    abstract public GPhone Create(String String);
}
