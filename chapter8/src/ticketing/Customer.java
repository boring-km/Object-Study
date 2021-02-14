package ticketing;

public class Customer {
    private final String name;
    private Money money;

    public String getName() {
        return name;
    }

    public Customer(String name, Money money) {
        this.name = name;
        this.money = money;
    }

    private boolean takeOut(Money money) {
        this.money = this.money.minus(money);
        return true;
    }

    public boolean pay(Money money) {
        return this.money.isPayable(money) && takeOut(money);
    }
}
