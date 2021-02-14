package delivery;

public class Customer {

    private long money;

    public Customer(long money) {
        this.money = money;
    }

    public boolean pay(long calculateFee) {
        if (money >= calculateFee) {
            money -= calculateFee;
            return true;
        }
        return false;
    }
}
