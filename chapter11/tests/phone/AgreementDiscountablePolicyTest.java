package phone;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class AgreementDiscountablePolicyTest {
    @Test
    public void 약정할인을_받으면() {
        RatePolicy basicPolicy = new RegularPolicy(Money.wons(50000), Duration.ofMinutes(5));
        Phone phone = new Phone(basicPolicy);
        RatePolicy additionalPolicy = new AgreementDiscountablePolicy(basicPolicy, "_5GXPrime", Money.wons(1000));
        Money result = additionalPolicy.calculateFee(phone);
        assertEquals(Money.wons(49000), result);
    }
}