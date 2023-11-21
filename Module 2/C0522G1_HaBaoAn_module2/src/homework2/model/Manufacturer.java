package homework2.model;

import java.util.ArrayList;

public class Manufacturer {
    private int licenseManufacturer;
    private String nameOfManufacturer;
    private String country;

    public Manufacturer() {
    }

    public Manufacturer(int licenseManufacturer, String nameOfManufacturer, String country) {
        this.licenseManufacturer = licenseManufacturer;
        this.nameOfManufacturer = nameOfManufacturer;
        this.country = country;
    }

    public int getLicenseManufacturer() {
        return licenseManufacturer;
    }

    public void setLicenseManufacturer(int licenseManufacturer) {
        this.licenseManufacturer = licenseManufacturer;
    }
}
