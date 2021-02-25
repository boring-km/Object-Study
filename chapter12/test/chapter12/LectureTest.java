package chapter12;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LectureTest {
    @Test
    public void 객체지향_프로그래밍_수업_pass_기준이_70일때_합격이_3_불합격이_2이다() {
        Lecture lecture = new Lecture("객체지향 프로그래밍",
                70,
                Arrays.asList(81, 95, 75, 50, 45));
        String expected = lecture.evaluate();
        String actual = "Pass:3 Fail:2";
        assertEquals(expected, actual);
    }
}