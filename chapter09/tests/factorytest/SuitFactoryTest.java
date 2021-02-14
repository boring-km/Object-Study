package factorytest;

import org.junit.Test;

import static org.junit.Assert.*;

public class SuitFactoryTest {

    @Test
    public void SuitFactory에_hydro를_입력하면_하이드로_수트를_이름으로_가지고_있다() {
        Suit suit = SuitFactory.valueOf("Hydro").factory.get();
        assertEquals(new HydroSuit().getName(), suit.getName());
    }
}