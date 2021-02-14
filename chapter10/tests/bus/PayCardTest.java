package bus;

import org.junit.Test;

import static org.junit.Assert.*;

public class PayCardTest {

    /*
    똑같은 getMoney()를 사용하고 있지만 그 의미가 좀 다르다면?
     */

    @Test
    public void 신용카드로_사용하지_않으면_사용한_카드의_금액은_0이다() {
        PayCard payCard = new CreditCard(25, 0.9, 300000);
        assertEquals(0, payCard.getMoney());
    }

    @Test
    public void _10만이_들어있는_버스카드를_사용하지_않으면_남은_잔액은_10만이다() {
        PayCard payCard = new BusCard(25, 100000);
        assertEquals(100000, payCard.getMoney());
    }
}