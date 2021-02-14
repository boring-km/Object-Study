package bus;

public class ExpressBus implements Bus {

    private enum BusFee {
        Adult(19, 2300),
        Youth(13, 1360),
        Children(7, 1200);
        private final int age;
        private final long fee;

        BusFee(int age, long fee) {
            this.age = age;
            this.fee = fee;
        }
    }

    @Override
    public long calculateFee(int age) {
        if (BusFee.Adult.age < age) return BusFee.Adult.fee;
        else if (BusFee.Youth.age < age) return BusFee.Youth.fee;
        else return BusFee.Children.fee;
    }
}
