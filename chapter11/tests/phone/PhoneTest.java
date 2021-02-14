package phone;

import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneTest {
    private Call callOfOneHourFiveMinute;

    @Before
    public void setUp() {
        // 1시간 5분짜리 통화
        callOfOneHourFiveMinute = new Call(LocalDateTime.of(2020, 8, 3, 15, 1),
                LocalDateTime.of(2020, 8, 3, 16, 6));
    }

    @Test
    public void _100초당_100원의_요금을_내는_Regular정책인_Phone으로_1시간_5분_통화하면_요금은_3900원이다() {
        Phone regularPolicyPhone = new Phone(
                new RegularPolicy(Money.wons(100), Duration.ofSeconds(100))
        );
        regularPolicyPhone.call(callOfOneHourFiveMinute);
        Money result = regularPolicyPhone.calculateFee();
        assertThat(Money.wons(3900)).isEqualTo(result);
    }

    @Test
    public void 고정요금이_30000원인_Phone은_전화를_사용하지_않아도_30000원이고_전화를_사용해도_30000원이다() {
        Phone fixableRatePolicyPhone = new Phone(
                new FixedRatePolicy(Money.wons(30000))
        );
        assertThat(Money.wons(30000)).isEqualTo(fixableRatePolicyPhone.calculateFee());
        fixableRatePolicyPhone.call(callOfOneHourFiveMinute);
        assertThat(Money.wons(30000)).isEqualTo(fixableRatePolicyPhone.calculateFee());
    }

    @Test
    public void 기본요금이_100초당_100원의_요금을_내는_Regular정책에_10퍼센트의_세금이_추가되는_정책으로_1시간_5분_통화하면_요금은_4290원이다() {
        Phone taxablePolicyPhone = new Phone(
                new TaxablePolicy(
                        new RegularPolicy(Money.wons(100), Duration.ofSeconds(100)),
                        0.1
                )
        );
        taxablePolicyPhone.call(callOfOneHourFiveMinute);
        assertThat(Money.wons(4290)).isEqualTo(taxablePolicyPhone.calculateFee());
    }
}
