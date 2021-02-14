package chapter01.kangmin;

import java.time.LocalDateTime;

public class Invitation {

    public Invitation(LocalDateTime when) {
        System.out.println("초대장 날짜/시간: " + when.toString());
    }
}
