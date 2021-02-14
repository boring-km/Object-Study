package smartphone.order;

public class SmartPhoneOrder {
    private final String manufacturer;
    private final String modelName;

    public SmartPhoneOrder(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

}
