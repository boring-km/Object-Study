package bus;

public class BusCard extends PayCard {

    private long money;

    public BusCard(int userAge, long money) {
        super(userAge);
        this.money = money;
    }

    @Override
    protected void pay(long busFee) {
        if (money >= busFee) money -= busFee;
        else throw new IllegalStateException("버스에 탈 돈이 부족함");
    }

    @Override
    protected long getMoney() {
        return money;
    }

}
