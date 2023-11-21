package module_2_final.model;

public abstract class Vehical {
    private String vehicalCode;
    private String vehicalName;
    private String manufacturer;
    private int yearOfManufacture;
    private long wattage;
    private double v;

    public Vehical() {
    }

    public Vehical(String vehicalCode,
                   String vehicalName,
                   String manufacturer,
                   int yearOfManufacture,
                   long wattage,
                   double v) {
        this.vehicalCode = vehicalCode;
        this.vehicalName = vehicalName;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.wattage = wattage;
        this.v = v;
    }

    public String getVehicalCode() {
        return vehicalCode;
    }

    public void setVehicalCode(String vehicalCode) {
        this.vehicalCode = vehicalCode;
    }

    public String getVehicalName() {
        return vehicalName;
    }

    public void setVehicalName(String vehicalName) {
        this.vehicalName = vehicalName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public long getWattage() {
        return wattage;
    }

    public void setWattage(long wattage) {
        this.wattage = wattage;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return
                " Mã phương tiện: " + vehicalCode + '\'' +
                " Tên phương tiện: " + vehicalName + '\'' +
                " Hãng sản xuất: " + manufacturer + '\'' +
                " Năm sản xuất: " + yearOfManufacture +
                " Công suất: " + wattage +
                " Dung tích xi lanh: " + v;
    }
}
