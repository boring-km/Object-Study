package delivery;

import org.junit.Test;

import static org.junit.Assert.*;

public class NormalDeliveryPackageTest {

    @Test
    public void _이름이_공책이고_무게가_20이며_할인율이_0인_물품의_배송료는_3000이다() {
        DeliveryPackage deliveryPackage = new DeliveryPackage("공책", 20, 0);
        long deliveryFee = deliveryPackage.calculateWeightFee();
        assertEquals(4500, deliveryFee);
    }
}