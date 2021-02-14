package smartphone.smartphones;

public class AppleSmartPhone extends DefaultSmartPhone {
    private static final String manufacturer = "애플";

    public AppleSmartPhone(long price, String modelName) {
        super(price, manufacturer, modelName);
    }
}