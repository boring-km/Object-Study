package schedule;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private final String subject;   // 사용하지 않지만 그대로 둔다.
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }
    // 쿼리: from과 duration이 schedule의 상태와 비교하여 일치여부를 확인한다.
    public boolean isSatisfied(RecurringSchedule schedule) {
        return from.getDayOfWeek() == schedule.getDayOfWeek() &&
                from.toLocalTime().equals(schedule.getFrom()) &&
                duration.equals(schedule.getDuration());
    }
    // 변경: from과 duration 상태를 변경한다.
    public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)),
                schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long daysDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
