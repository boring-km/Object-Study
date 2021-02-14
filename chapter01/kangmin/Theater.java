package chapter01.kangmin;

public class Theater {
    private final TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void invite(Audience audience) {
        ticketSeller.check(audience);
    }
}
