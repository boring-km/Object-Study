package ticketing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer kangmin;

    @Before
    public void _3만원을_들고_있는_진강민_고객이_있다() {
        kangmin = new Customer(
                "진강민",
                Money.wons(30000)
        );
    }

    @Test
    public void 강민이가_10000원을_지불하려고하면_가능하다() {
        assertTrue(kangmin.pay(Money.wons(10000)));
    }

    @Test
    public void 강민이가_50000원을_지불하려고하면_불가능하다() {
        assertFalse(kangmin.pay(Money.wons(50000)));
    }
}