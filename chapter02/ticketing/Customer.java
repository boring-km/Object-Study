package chapter02.ticketing;

public class Customer {

    private Screening screening;
    private long money;
    private long fee;

    public Customer(long money) {
        this.money = money;
    }

    public void reserve(Screening screening) {
        this.screening = screening;
        checkFee();
        pay();
    }

    private void checkFee() {
        fee = screening.calculate();
        System.out.println("지불 금액: " + fee);
    }

    private void pay() {
        money -= fee;
        System.out.println("남은 금액: " + money);
    }
}
