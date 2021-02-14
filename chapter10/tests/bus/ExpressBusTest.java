package bus;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressBusTest {

    @Test
    public void 고속버스에_나이가_25인_사람의_요금은_2300이다() {
        long fee = new ExpressBus().calculateFee(25);
        assertEquals(2300, fee);
    }
}