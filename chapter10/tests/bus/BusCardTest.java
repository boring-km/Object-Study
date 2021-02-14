package bus;

import org.junit.Test;

import static org.junit.Assert.*;

public class BusCardTest {

    @Test
    public void _사용자_나이가_25살이고_돈이_10000_있는_버스카드로_마을버스를_타면_잔액이_8800이다() {
        BusCard busCard = new BusCard(25, 10000);
        busCard.payFor(new CityBus());
        long result = busCard.getMoney();
        assertEquals(8800, result);
    }

    @Test
    public void _사용자_나이가_18살이고_돈이_3000_있는_버스카드로_고속버스를_타면_잔액이_1640이다() {
        PayCard payCard = new BusCard(18, 3000);
        payCard.payFor(new ExpressBus());
        long result = payCard.getMoney();
        assertEquals(1640, result);
    }
}