package homework2.model;

public class Vehical {
    private int licensePlate;
    private String manufacturer;
    private int yearOfManufacture;
    private String owner ;

    public Vehical() {
    }

    public Vehical(int licensePlate, String manufacturer, int yearOfManufacture, String owner) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public int getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(int licensePlate) {
        this.licensePlate = licensePlate;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return
                " Biển số xe " + licensePlate +
                ", Hãng sản xuất  " + manufacturer +
                ", Năm sản xuất " + yearOfManufacture +
                ", Chủ sở hữu " + owner;
    }
}
