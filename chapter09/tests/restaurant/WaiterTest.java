package restaurant;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaiterTest {

    @Test
    public void 주문한_음식의_이름이_똑같은_참치김밥과_칼국수이어도_주문한_테이블_번호가_다르면_다른_주문이다() {
        int foodOrder1 = new FoodOrder(101, "참치김밥", "칼국수").getTableNumber();
        int foodOrder2 = new FoodOrder(102, "참치김밥", "칼국수").getTableNumber();
        assertNotEquals(foodOrder1, foodOrder2);
    }
}
