package chapter01.kangmin;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public Bag(long amount) {
        this(null, amount);
    }
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public boolean hasTicket() {
        return ticket != null;
    }
    public void minusAmount(Long amount) {
        this.amount -= amount;
        System.out.println("가방에 남은 현금: " + this.amount);
    }

}
