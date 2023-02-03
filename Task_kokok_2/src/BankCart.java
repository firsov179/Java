class BankCart extends ElectronicCartDecorator {

    private final String bankName;
    private final int number;
    public BankCart(ElectronicInterface c, int n, String name) {
        super(c);
        bankName = name;
        number = n;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.printf("\tБанковские реквизиты: \n\t\tИмя банка: %s.\n\t\tНомер счета: %d.\n", bankName, number);
    }
}