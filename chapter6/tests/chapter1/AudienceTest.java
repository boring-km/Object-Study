package chapter1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AudienceTest {

    private Audience audienceWithInvitation;
    private Audience audienceWithoutInvitation;

    @Before
    public void 초대장과_현금_10000을_가진_관객과_초대장_없이_현금_10000을_가진_관객이_있다() {
        audienceWithInvitation = new Audience(
                new Bag(
                        new Invitation(),
                        10000L
                )
        );
        audienceWithoutInvitation = new Audience(
                new Bag(10000L)
        );
    }

    @Test
    public void 초대장이_있는_고객이_금액이_10000인_티켓을_사면_요금이_0이다(){
        assertEquals(Long.valueOf(0), audienceWithInvitation.buy(new Ticket(10000L)));
    }

    @Test
    public void 초대장이_없는_고객이_금액이_10000인_티켓을_사면_요금이_10000이다(){
        Long fee = 10000L;
        assertEquals(fee, audienceWithoutInvitation.buy(new Ticket(fee)));
    }

    @Test
    public void 초대장이_없는_고객이_돈을_8000만큼_갖고있을때_금액이_10000인_티켓을_사면_요금이_0이다(){
        audienceWithoutInvitation = new Audience(new Bag(8000L));
        Long fee = 10000L;
        assertEquals(Long.valueOf(0L), audienceWithoutInvitation.buy(new Ticket(fee)));
    }
}