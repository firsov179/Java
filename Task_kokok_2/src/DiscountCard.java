class DiscountCard extends ElectronicCartDecorator {

    private String level;
    private int countPoints;
    public DiscountCard(ElectronicInterface c, int points) {
        super(c);
        countPoints = points;
        if (points > 1000) {
            level = "PLATINUM";
        } else {
            level = "SILVER";
        }
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.printf("\tДанные скидочной карты:\n\t\tУровень членства: %s\n\t\tКолличество бонусов: %d\n", level, countPoints);
    }
}