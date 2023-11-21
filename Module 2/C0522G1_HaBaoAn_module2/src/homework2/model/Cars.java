package homework2.model;

public class Cars extends Vehical{
    private String vehicalType;
    private int seats;

    public Cars() {
    }

    public Cars(String vehicalType, int seats) {
        this.vehicalType = vehicalType;
        this.seats = seats;
    }

    public Cars(int licensePlate, String manufacturer, int yearOfManufacture, String owner, String vehicalType, int seats) {
        super(licensePlate, manufacturer, yearOfManufacture, owner);
        this.vehicalType = vehicalType;
        this.seats = seats;
    }

    public String getVehicalType() {
        return vehicalType;
    }

    public void setVehicalType(String vehicalType) {
        this.vehicalType = vehicalType;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return super.toString() + ", Kiểu xe " + vehicalType +
                ", Số ghế " + seats;
    }
}
