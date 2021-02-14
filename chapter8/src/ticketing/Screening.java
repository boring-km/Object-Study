package ticketing;

import java.time.LocalDateTime;

public class Screening {

    private final int sequence;
    private final LocalDateTime whenScreened;

    public Screening(int sequence, LocalDateTime whenScreened) {
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }
}
