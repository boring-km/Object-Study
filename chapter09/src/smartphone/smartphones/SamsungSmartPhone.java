package smartphone.smartphones;

public class SamsungSmartPhone extends DefaultSmartPhone {
    private static final String manufacturer = "삼성";

    public SamsungSmartPhone(long price, String modelName) {
        super(price, manufacturer, modelName);
    }
}