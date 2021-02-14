package chapter01.kangmin;

public class Ticket {
    private final Long fee;

    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}
