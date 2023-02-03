import GPhonePackage.*;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GPhoneCreater> factories = new ArrayList<>();
        factories.add(new GPhoneClassicCreater("ООО 'Телефон в каждый дом'"));
        factories.add(new GPhonePremiumUltimaPlusXCreater("ЗАО 'ElitPhones'"));
        ArrayList<GPhone> phones = new ArrayList<>();
        String[] Strings = new String[]{"BLUE", "RED", "CYAN", "GRAY"};
        for (int i = 0; i < 10; ++i) {
            if (i % 3 == 2) {
                phones.add(new GPhonePremiumUltimaPlusX(Strings[i % 4]));
            } else {
                phones.add(new GPhoneClassic(Strings[i % 4]));
            }
            phones.get(i).getInfo();
        }

        for (int i = 0; i < 10; i = i + 2) {
            phones.get(i).call("+7(926)-111-22-33");
        }
    }
}