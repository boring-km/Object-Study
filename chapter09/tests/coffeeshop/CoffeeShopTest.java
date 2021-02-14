package coffeeshop;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeShopTest {

    private static Customer customer;

    @BeforeClass
    public static void 고객_객체_초기화() {
        customer = new Customer();
    }

    @Test(expected = NullPointerException.class)
    public void 고객이_설탕의_스푼수를_정하지_않고_바리스타에게_아메리카노를_주문하면_NPE가_발생한다() {
        Coffee coffee = customer.order(new Barista(), "아메리카노");
        coffee.taste();
    }

    @Test
    public void 고객이_설탕_2스푼을_정하고_바리스타에게_아메리카노를_주문하면_아메리카노_맛에_설탕_2스푼_들어간_커피다() {
        SugarServiceLocator.setSugar(new Sugar(2));
        Coffee coffee = customer.order(new Barista(), "아메리카노");
        assertEquals("아메리카노 맛에 설탕 2스푼 들어간 커피", coffee.taste());
    }
}