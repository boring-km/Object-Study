package schedule;

import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class EventTest {

    private RecurringSchedule schedule;

    @Before
    public void 매주_금요일_14시_30분부터_30분_동안_진행되는_회의가_있다(){
        schedule = new RecurringSchedule("회의", DayOfWeek.FRIDAY, LocalTime.of(10, 30), Duration.ofMinutes(30));
    }

    @Test
    public void 회의가_2020년_5월_22일_00시_30분부터_30분_동안_진행되면_반복일정을_만족하지_않는다() {
        Event meeting = new Event("회의", LocalDateTime.of(2020,5,22,0,30), Duration.ofMinutes(30));
        assertFalse(meeting.isSatisfied(schedule));
    }

    @Test
    public void 회의가_2020년_5월_23일_14시_30분부터_30분_동안_진행되면_반복일정을_만족하지_않아야_한다() {
        Event meeting = new Event("회의", LocalDateTime.of(2020,5,23,14,30), Duration.ofMinutes(30));
        assertFalse(meeting.isSatisfied(schedule));
        assertFalse(meeting.isSatisfied(schedule));  // 2번 호출해도 결과가 변하지 않음
    }

    @Test
    public void 반복일정을_만족하지_않는_회의를_반복일정에_맞춰서_reshedule하면_반복일정을_만족한다() {
        Event meeting = new Event("회의", LocalDateTime.of(2020,5,23,14,30), Duration.ofMinutes(30));
        assertFalse(meeting.isSatisfied(schedule));

        meeting.reschedule(schedule);
        assertTrue(meeting.isSatisfied(schedule));
    }
}