package homework2.model;

public class Truck extends Vehical{
    private double weight;

    public Truck() {
    }

    public Truck(double weight) {
        this.weight = weight;
    }

    public Truck(int licensePlate, String manufacturer, int yearOfManufacture, String owner, double weight) {
        super(licensePlate, manufacturer, yearOfManufacture, owner);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
