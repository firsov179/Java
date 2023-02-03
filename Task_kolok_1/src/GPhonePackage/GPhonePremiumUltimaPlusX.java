package GPhonePackage;

import java.awt.*;

public class GPhonePremiumUltimaPlusX extends GPhone {

    public GPhonePremiumUltimaPlusX(String String) {
        super(String);
    }
    @Override
    public void call(String phoneNumber) {
        System.out.printf("Доброе уторо!\nК сожалению, Пользователь %s не смог ответить.\n", phoneNumber);
        System.out.println("Надеемся, Вы сможете связаться с ним позже.");
        System.out.println("Искренне ваш, GPhone Premium Ultima Plus X.\n");
    }

    @Override public void getInfo() {
        System.out.println("Это самый лучший на свете GPhone Premium Ultima Plus X.");
        System.out.printf("Он превосходного %s цвета.\n", getString());
        System.out.printf("Ваш персональный намер %d.\n\n", getId());
    }
}
