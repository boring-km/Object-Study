package chapter02.ticketing;

import java.time.LocalDateTime;

public class PeriodDiscountCondition implements DiscountCondition {

    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public PeriodDiscountCondition(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean check(Screening screening) {
        return screening.getShowingTime().isAfter(LocalDateTime.from(this.startTime)) &&
                screening.getShowingTime().isBefore(LocalDateTime.from(this.endTime));
    }
}
