package GPhonePackage;

import java.awt.*;
import java.io.Console;

abstract public class GPhone {

    static int globalId = 1;

    GPhone(String newGphoneString) {
        String = newGphoneString;
        id = globalId;
        globalId = globalId * 23 % 179;
    }
    private String String;
    private  int id;

    public String getString() {
        return String;
    }
    public int getId() {
        return id;
    }

    public abstract void getInfo();
    public void call(String phoneNumber) {
        System.out.printf("Пользователь %s не отвечает.\nПопробуйте перезвонить позже.\n\n", phoneNumber);
    }
}
