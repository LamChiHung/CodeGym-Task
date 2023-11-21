package module_2_final.model;

public class Cars extends Vehical {
    private String engineType;
    private int seats;

    public Cars() {
    }

    public Cars(String vehicalCode,
                String vehicalName,
                String manufacturer,
                int yearOfManufacture,
                long wattage,
                double v,
                String engineType,
                int seats) {
        super(vehicalCode, vehicalName, manufacturer, yearOfManufacture, wattage, v);
        this.engineType = engineType;
        this.seats = seats;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    @Override
    public String toString() {
        return super.toString() +
                " Loại động cơ: " + engineType +
                " Số chỗ ngồi: " + seats;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                getVehicalCode(),
                getVehicalName(),
                getManufacturer(),
                getYearOfManufacture(),
                getWattage(),
                getV(),
                getEngineType(),
                getSeats());
    }
}
