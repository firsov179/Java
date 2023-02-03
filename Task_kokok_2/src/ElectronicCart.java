class ElectronicCart implements ElectronicInterface {

    private static int globalId = 57;
    private String name;
    private int id;
    public ElectronicCart(String newName) {
        name = newName;
        id = globalId;
        globalId = globalId * 23 % 179;
    }
    @Override
    public void getInfo() {
        System.out.printf("Данные электронной карты:\n\tФИО: %s\n\tНомер электронной карты: %d\n", name, id);
    }
}