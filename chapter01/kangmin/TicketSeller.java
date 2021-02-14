package chapter01.kangmin;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void check(Audience audience) throws IndexOutOfBoundsException {
        Ticket ticket = ticketOffice.getTicket();
        if (!audience.hasInvitation()) {                                // 관객의 가방에 초대장이 없으면
            audience.minusAmount(ticket.getFee());   // 관객의 가방에서 티켓의 요금만큼 현금이 빠진다.
            ticketOffice.plusAmount(ticket.getFee());   // 매표소에서 티켓의 요금만큼 현금이 채워진다.
        }
        audience.setTicket(ticket);       // 관객의 가방에 티켓 들어감
    }
}
