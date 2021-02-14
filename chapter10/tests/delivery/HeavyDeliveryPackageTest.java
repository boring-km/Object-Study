package delivery;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeavyDeliveryPackageTest {
    @Test
    public void 무게가_300이고_할인율이_10퍼센트인_TV의_배송료는_56250이다() {
        DeliveryPackage tv = new HeavyDeliveryPackage("TV", 300, 0.1);
        assertEquals(56250, tv.calculateWeightFee());
    }
}