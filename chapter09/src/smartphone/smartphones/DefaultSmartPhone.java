package smartphone.smartphones;

import smartphone.order.SmartPhone;

public abstract class DefaultSmartPhone implements SmartPhone {
    private final long price;
    private final String manufacturer;
    private final String modelName;

    public DefaultSmartPhone(long price, String manufacturer, String modelName) {
        this.price = price;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }

    @Override
    public String getSmartPhoneInfo() {
        return "제조사: " + manufacturer + " 모델명: " + modelName + " 가격: " + price;
    }

}