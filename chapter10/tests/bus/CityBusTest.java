package bus;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityBusTest {
    @Test
    public void 나이가_10살이면_버스의_요금은_450이다() {
        long fee = new CityBus().calculateFee(10);
        assertEquals(450, fee);
    }

    @Test
    public void 나이가_20살이면_버스의_요금은_1200이다() {
        long fee = new CityBus().calculateFee(20);
        assertEquals(1200, fee);
    }
}