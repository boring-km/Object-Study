package chapter02.ticketing;

import java.time.LocalDateTime;

public class Screening {
    private final LocalDateTime showingTime;
    private final Integer order;
    private final Movie movie;

    public LocalDateTime getShowingTime() {
        return showingTime;
    }

    public Integer getOrder() {
        return order;
    }

    public long calculate() {
        return movie.getDiscountFee(this);
    }

    public Screening(LocalDateTime showingTime, Integer order, Movie movie) {
        this.showingTime = showingTime;
        this.order = order;
        this.movie = movie;
    }
}
