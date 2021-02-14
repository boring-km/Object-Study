package inheritance;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test(expected = IllegalArgumentException.class)
    public void 바바리사자가_대파를_먹으려고_하면_IllegalArgumentException_예외가_발생한다() {
        Animal leo = new Lion("바바리사자");
        leo.eat(new Vegetable("대파"));
    }

    @Test
    public void 아프리카코끼리가_소고기를_먹으려고_하면_IllegalArgumentException_예외가_발생한다() {
        Animal africanElephant = new Elephant("아프리카코끼리");
        africanElephant.eat(new Meat("소고기"));
    }
}