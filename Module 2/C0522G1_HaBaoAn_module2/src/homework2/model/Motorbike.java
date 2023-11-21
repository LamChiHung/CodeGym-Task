package homework2.model;

public class Motorbike extends Vehical{
    private int wattage;

    public Motorbike() {
    }

    public Motorbike(int wattage) {
        this.wattage = wattage;
    }

    public Motorbike(int licensePlate, String manufacturer, int yearOfManufacture, String owner, int wattage) {
        super(licensePlate, manufacturer, yearOfManufacture, owner);
        this.wattage = wattage;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}
