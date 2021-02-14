package chapter01.kangmin;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }
    public void minusAmount(Long fee) {
        bag.minusAmount(fee);
    }
    public void setTicket(Ticket ticket) {
        bag.setTicket(ticket);
    }

}
