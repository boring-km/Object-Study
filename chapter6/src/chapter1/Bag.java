package chapter1;

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

    public Long keep(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return ticket.getFree();
        } else {
            return getFeeWithoutInvitation(ticket);
        }
    }

    private Long getFeeWithoutInvitation(Ticket ticket) {
        if (isPossibleToBuy(ticket.getFee())) {
            minusAmount(ticket.getFee());
            setTicket(ticket);
            return ticket.getFee();
        }
        return ticket.getFree();
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private boolean isPossibleToBuy(Long fee) {
        return this.amount >= fee;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean hasTicket() {
        return this.ticket != null;
    }
}
