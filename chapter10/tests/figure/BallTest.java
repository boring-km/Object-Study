package figure;

import org.junit.Test;

import static org.junit.Assert.*;

public class BallTest {
    @Test
    public void 반지름이_4인_구의_겉넓이는_반올림해서_201이다() {
        Ball ball = new Ball(4);
        assertEquals(201, Math.round(ball.calculateSurfaceArea()));
        assertNotEquals(201, Math.round(ball.calculateArea()));
    }
}