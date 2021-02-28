package chapter12;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ProfessorTest {

    @Test
    public void Lecture_클래스를_이용해_성적_통계를_계산한_결과가_맞는지_테스트한다() {
        // given
        Professor professor = new Professor("다익스트라",
                new Lecture("알고리즘",
                        70,
                        Arrays.asList(81, 95, 75, 50, 45)));
        // when
        String statistics = professor.compileStatistics();
        // then
        String expected = "[다익스트라] Pass:3 Fail:2 - Avg: 69.2";
        assertEquals(expected, statistics);
    }

    @Test
    public void GradeLecture_클래스를_이용해_성적_통계를_계산한_결과가_맞는지_테스트한다() {
        // given
        Professor professor = new Professor("다익스트라",
                new GradeLecture("알고리즘",    // 업캐스팅
                        70,
                        Arrays.asList(new Grade("A", 100, 95),
                                new Grade("B", 94, 80),
                                new Grade("C", 79, 70),
                                new Grade("D", 69, 50),
                                new Grade("F", 49, 0)),
                        Arrays.asList(81, 95, 75, 50, 45)));
        // when
        String statistics = professor.compileStatistics();  // 런타임에 결정하는 동적 바인딩
        // then
        String expected = "[다익스트라] Pass:3 Fail:2, A:1 B:1 C:1 D:1 F:1 - Avg: 69.2";
        assertEquals(expected, statistics);
    }
}