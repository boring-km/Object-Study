package smartphone.order;

import smartphone.smartphones.*;

import java.util.Arrays;

public enum SmartPhoneFactory {
    GALAXY_S20("삼성", new SamsungSmartPhone(1200000, "갤럭시S20")),
    IPHONE11PRO("애플", new AppleSmartPhone(2000000, "아이폰11pro")),
    MATE20X("화웨이", new HuaweiSmartPhone(500000, "Mate20X")),
    VELVET("LG", new LGSmartPhone(890000, "VELVET")),
    NONE_SMARTPHONE("", new NoneSmartPhone());

    private final String manufacturer;
    private final SmartPhone defaultSmartPhone;

    SmartPhoneFactory(String manufacturer, SmartPhone defaultSmartPhone) {
        this.manufacturer = manufacturer;
        this.defaultSmartPhone = defaultSmartPhone;
    }

    public static SmartPhone createSmartPhone(SmartPhoneOrder smartPhoneOrder) {
        SmartPhoneFactory smartPhoneFactory = Arrays.stream(SmartPhoneFactory.values())
                .filter(smartPhone -> smartPhone.isCorrectManufacturer(smartPhoneOrder))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        return smartPhoneFactory.defaultSmartPhone;
    }

    private boolean isCorrectManufacturer(SmartPhoneOrder smartPhoneOrder) {
        return this.manufacturer.equals(smartPhoneOrder.getManufacturer());
    }
}
