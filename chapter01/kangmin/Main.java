package chapter01.kangmin;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Bag bag1 = new Bag(new Invitation(LocalDateTime.of(2020, 4, 11, 10,0)), 10000L);
        Audience audience1 = new Audience(bag1);

        Bag bag2 = new Bag(10000L);
        Audience audience2 = new Audience(bag2);

        Theater theater = new Theater(new TicketSeller(
                new TicketOffice(1000000L, new Ticket(8000L), new Ticket(8000L))
        ));
        theater.invite(audience1);
        theater.invite(audience2);

        if (bag1.hasTicket()) {
            System.out.println("1 입장");
        }
        if (bag2.hasTicket()) {
            System.out.println("2 입장");
        }
    }
}
