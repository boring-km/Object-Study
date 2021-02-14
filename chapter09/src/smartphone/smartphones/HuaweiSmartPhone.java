package smartphone.smartphones;

public class HuaweiSmartPhone extends DefaultSmartPhone {
    private static final String manufacturer = "화웨이";

    public HuaweiSmartPhone(long price, String modelName) {
        super(price, manufacturer, modelName);
    }
}