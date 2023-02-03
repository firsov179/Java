abstract class ElectronicCartDecorator implements ElectronicInterface {
    protected ElectronicInterface component;

    public ElectronicCartDecorator (ElectronicInterface c) {
        component = c;
    }

    @Override
    public void getInfo() {
        component.getInfo();
    }

    public void newOperation() {
        System.out.println("Do Nothing");
    }
}