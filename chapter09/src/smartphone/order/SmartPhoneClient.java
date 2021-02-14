package smartphone.order;

public class SmartPhoneClient {

    public SmartPhone getSmartPhone(SmartPhoneOrder smartPhoneOrder) {
        return SmartPhoneFactory.createSmartPhone(smartPhoneOrder);
    }
}
