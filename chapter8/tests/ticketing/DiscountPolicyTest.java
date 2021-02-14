package ticketing;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class DiscountPolicyTest {

    DiscountPolicy amountDiscountPolicy;
    DiscountPolicy percentDiscountPolicy;

    @Before
    public void 할인정책이_첫번째_순서이거나_2020년_6월_10일부터_14일까지이면_1000을_할인해주는_현금할인_정책이_있다() {
        amountDiscountPolicy = new AmountDiscountPolicy(
                Money.wons(1000),
                new SequenceCondition(1), new PeriodCondition(
                LocalDateTime.of(2020, 6, 10, 0, 0),
                LocalDateTime.of(2020, 6, 14, 23, 59))
        );
    }

    @Test
    public void 첫번째_상영순서에_2020년_6월_12일_10시_0분에_시작하고_요금이_10000원일때_현금할인정책으로_할인금액을_계산하면_1000원이다() {

        Money discountedMoney = amountDiscountPolicy.calculateDiscountAmount(
                new Screening(1, LocalDateTime.of(2020, 6, 12, 10, 0)),
                Money.wons(10000)
        );
        assertEquals(Money.wons(1000), discountedMoney);

    }

    @Before
    public void 할인정책이_첫번째_순서이거나_2020년_6월_10일부터_14일까지이면_8퍼센트를_할인해주는_비율할인_정책이_있다() {
        percentDiscountPolicy = new PercentDiscountPolicy(
                0.08,
                new SequenceCondition(1), new PeriodCondition(
                LocalDateTime.of(2020, 6, 10, 0, 0),
                LocalDateTime.of(2020, 6, 14, 23, 59))
        );
    }

    @Test
    public void 첫번째_상영순서에_2020년_6월_12일_10시_0분에_시작하고_요금이_10000원일때_비율할인정책으로_할인금액을_계산하면_800원이다() {

        Money discountedMoney = percentDiscountPolicy.calculateDiscountAmount(
                new Screening(1, LocalDateTime.of(2020, 6, 12, 10, 0)),
                Money.wons(10000)
        );
        assertEquals(Money.wons(800), discountedMoney);

    }
}