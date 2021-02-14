package chapter1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketSellerTest {

    private TicketSeller ticketSeller;

    @Before
    public void 현금이_700000있고_요금이_10000인_티켓이_2개_있는_매표소의_티켓판매원을_정의한다() {
        ticketSeller = new TicketSeller(
                new TicketOffice(
                        700000L,
                        new Ticket(10000L), new Ticket(10000L)
                )
        );
    }

    @Test
    public void 티켓판매원은_가방에_초대장이_없고_현금이_20000있는_관객에게_티켓을_팔면_팔린다() {
        assertTrue(ticketSeller.sellTo(
                new Audience(
                        new Bag(
                                20000L
                        )
                )
        ));
    }

    @Test
    public void 티켓판매원은_초대장이_가방에_없고_현금이_4000있는_관객에게_티켓을_팔면_팔_수_없다() {
        assertFalse(ticketSeller.sellTo(
                new Audience(
                        new Bag(
                                4000L
                        )
                )
        ));
    }

}