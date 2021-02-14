package chapter1;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public boolean sellTo(Audience audience) {
        Long fee = audience.buy(ticketOffice.getTicket());
        ticketOffice.plusAmount(fee);
        return checkTicket(audience);
    }

    private boolean checkTicket(Audience audience) {
        return audience.haveTicketOrNot();
    }
}
