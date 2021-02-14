package chapter1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {

    private Bag bagWithInvitation;
    private Bag bagWithoutInvitation;

    @Before
    public void 초대장과_현금이_10000만큼_들어있는_가방과_초대장_없이_현금_10000이_들어있는_가방이_있다() {

        bagWithInvitation = new Bag(new Invitation(), 10000L);
        bagWithoutInvitation = new Bag(10000L);
    }

    @Test
    public void 가방에_초대장이_있으면_지불한_요금이_0이다() {
        assertEquals(Long.valueOf(0L), bagWithInvitation.keep(new Ticket(10000L)));
    }

    @Test
    public void 가방에_초대장이_없으면_티켓의_요금이_10000일때_지불하는_요금이_10000이다() {
        Long fee = 10000L;
        assertEquals(fee, bagWithoutInvitation.keep(new Ticket(fee)));
    }

    @Test
    public void 초대장이_없는_가방에_현금이_8000이고_요금이_10000이면_지불하는_요금이_0이다() {
        bagWithoutInvitation = new Bag(8000L);

        assertEquals(Long.valueOf(0L), bagWithoutInvitation.keep(new Ticket(10000L)));
    }
}
