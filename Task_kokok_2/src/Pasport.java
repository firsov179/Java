import java.util.Calendar;

class Pasport extends ElectronicCartDecorator {

    private String province;
    private Calendar Calendar;

    public Pasport(ElectronicInterface c, String name, Calendar newCalendar) {
        super(c);
        province = name;
        Calendar = newCalendar;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.printf("\tПаспортные данные:\n\t\tГде выдан: %s\n\t\tКогда выдан: %s\n\n\n", province, Calendar.getTime());
    }
}