package smartphone.order;

public class SmartPhoneAgency {
    public static void main(String[] args) {
        SmartPhoneClient client = new SmartPhoneClient();
        SmartPhone smartPhone = getSmartPhone(client);
        printSmartPhoneInfo(smartPhone);
    }

    private static void printSmartPhoneInfo(SmartPhone smartPhone) {
        System.out.println("해당 스마트폰 정보는 아래와 같습니다.\n" + smartPhone.getSmartPhoneInfo());
    }


    private static SmartPhone getSmartPhone(SmartPhoneClient client) {
        return client.getSmartPhone(new SmartPhoneOrder("삼성", "갤럭시S20"));
    }
}
