package chapter1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TheaterTest {

    private Theater theater;

    @Before
    public void 현금이_700000있고_요금이_10000인_티켓이_2개_있는_매표소에_티켓판매원이_있는_영화관을_정의한다() {
        theater = new Theater(
                new TicketSeller(
                        new TicketOffice(
                                700000L,
                                new Ticket(10000L), new Ticket(10000L)
                        )
                )
        );
    }

    @Test
    public void 초대장이_없는_관객이_가방에_현금이_10000이_있으면_영화관에_입장할_수_있다() {
        assertTrue(theater.enter(
                new Audience(
                        new Bag(
                                20000L
                        )
                )
        ));
    }

    @Test
    public void 초대장이_없는_관객이_가방에_현금이_4000이_있으면_영화관에_입장할_수_없다() {
        assertFalse(theater.enter(
                new Audience(
                        new Bag(
                                4000L
                        )
                )
        ));
    }
}