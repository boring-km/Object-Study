package delivery;

import org.junit.Test;

import static org.junit.Assert.*;

public class OvernightNormalDeliveryTest {

    @Test
    public void 거리가_100이고_추가요금이_3000이인_당일배송에_무게가_5이고_할인율이_0인_주문을_하면_돈이_5000있는_고객은_주문에_실패하고_돈이_5500있는_고객은_주문에_성공한다() {
        Delivery overnightNormalDelivery = new OvernightDelivery(100, 3000);
        Order order = new Order("물건", 5, 0);

        Customer notPayableCustomer = new Customer(5000);
        boolean result1 = overnightNormalDelivery.receive(notPayableCustomer, order);
        assertFalse(result1);

        Customer payableCustomer = new Customer(5500);
        boolean result2 = overnightNormalDelivery.receive(payableCustomer, order);
        assertTrue(result2);

    }
}