package ticketing;

import java.time.LocalDateTime;

public interface DiscountCondition {
    boolean check(Screening screening);
}

class SequenceCondition implements DiscountCondition {

    private final int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean check(Screening screening) {
        return sequence == screening.getSequence();
    }
}

class PeriodCondition implements DiscountCondition {

    private final LocalDateTime beginTime;
    private final LocalDateTime endTime;

    public PeriodCondition(LocalDateTime beginTime, LocalDateTime endTime) {

        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    @Override
    public boolean check(Screening screening) {
        return screening.getWhenScreened().isAfter(beginTime) &&
                screening.getWhenScreened().isBefore(endTime);
    }
}