package smartphone.smartphones;

public class LGSmartPhone extends DefaultSmartPhone {
    private static final String manufacturer = "LG";

    public LGSmartPhone(long price, String modelName) {
        super(price, manufacturer, modelName);
    }
}