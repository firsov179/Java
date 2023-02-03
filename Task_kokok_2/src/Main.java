import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        ElectronicCartDecorator skripach = new Pasport(
                new BankCart(
                        new DiscountCard(
                                new ElectronicCart("Гедеваном Александровичем Алексидзе"),
                                157),
                        112233, "ООО 'Банк Надёжность'"),
                "Тбилиси, Грузинская ССР", new GregorianCalendar(1969, Calendar.NOVEMBER, 16, 14, 5, 55));
        skripach.getInfo();


        ElectronicCartDecorator vova = new Pasport(
                new BankCart(
                        new DiscountCard(
                                new ElectronicCart("Владимир Николаевич Машков"),
                                1257),
                        377292, "ООО 'Банк Успех'"),
                "Тбилиси, Грузинская ССР", new GregorianCalendar(1933, Calendar.APRIL, 6, 12, 35 , 1));
        vova.getInfo();
    }
}