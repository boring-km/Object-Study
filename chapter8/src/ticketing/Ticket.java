package ticketing;

import java.time.Duration;

public class Ticket {

    private final String title;
    private final Duration duration;
    private final Customer customer;
    private final Screening screening;
    private final Money totalFee;
    private final int audienceCount;

    public Ticket(String title, Duration duration, Customer customer, Screening screening, Money totalFee, int audienceCount) {
        this.title = title;
        this.duration = duration;
        this.customer = customer;
        this.screening = screening;
        this.totalFee = totalFee;
        this.audienceCount = audienceCount;
    }

    public boolean sellToCustomer() {
        return customer.pay(totalFee); // 의문: 여기서 티켓을 고객에게 파는 것이 가장 나은 것일지...
    }

    public void printReservationInfo() {
        System.out.println("영화 제목: " + title +
                "\n영화 길이: " + duration.getSeconds() / 3600 + "시간 " + duration.getSeconds() % 60 + "분" +
                "\n예매 고객이름: " + customer.getName() +
                "\n예매한 영화의 순서: " + screening.getSequence() + "번째" +
                "\n예매한 시간: " + screening.getWhenScreened() +
                "\n예매 비용: " + totalFee.getAmount().intValue() + "원" +
                "\n예매한 관객수: " + audienceCount + "명");
    }
}