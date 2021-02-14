package chapter10;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InstrumentedHashSetTest {
    @Test
    public void InstrumentedHashSet의_잘못된_동작으로_addCount의_결과가_3이_아니다() {
        InstrumentedHashSet<String> fruits = new InstrumentedHashSet<>();
        fruits.addAll(Arrays.asList("Apple", "Grape", "Orange"));
        assertNotEquals(3, fruits.getAddCount());
    }
}