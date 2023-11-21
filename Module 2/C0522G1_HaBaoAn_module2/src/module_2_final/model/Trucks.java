package module_2_final.model;

public class Trucks extends Vehical {
    private long weight;

    public Trucks() {
    }

    public Trucks(String vehicalCode,
                  String vehicalName,
                  String manufacturer,
                  int yearOfManufacture,
                  long wattage,
                  double v,
                  long weight) {
        super(vehicalCode, vehicalName, manufacturer, yearOfManufacture, wattage, v);
        this.weight = weight;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getVehicalCode(),
                getVehicalName(),
                getManufacturer(),
                getYearOfManufacture(),
                getWattage(),
                getV(),
                getWeight());
    }

    @Override
    public String toString() {
        return super.toString() +
                " Tải trọng: " + weight;
    }
}
