package delivery;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NormalDeliveryTest {

    @Test
    public void 돈_10000을_가진_고객정보와_이름이_공책이고_무게가_5이며_할인율이_0이고_거리가_100인_주문을_받으면_결과는_참이다() {
        NormalDelivery normalDelivery = new NormalDelivery(100);
        boolean result = normalDelivery.receive(
                new Customer(10000), new Order("공책", 5, 0)
        );
        assertTrue(result);
    }
}
