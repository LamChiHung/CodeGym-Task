package model.facility;

import java.util.Objects;

public class Villa extends RentalService {
    private String standardRoom;
    private double areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String name, double area, double rentCost, int numberOfPeople, String rentType,
                 String standardRoom, double areaPool, int numberOfFloors) {
        super(name, area, rentCost, numberOfPeople, rentType);
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Villa villa = (Villa) o;
        return Double.compare(villa.areaPool, areaPool) == 0
                && numberOfFloors == villa.numberOfFloors
                && Objects.equals(standardRoom, villa.standardRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), standardRoom, areaPool, numberOfFloors);
    }

    @Override
    public String toString() {
        return super.toString() +
                "standardRoom='" + standardRoom + '\'' +
                ", areaPool=" + areaPool +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
