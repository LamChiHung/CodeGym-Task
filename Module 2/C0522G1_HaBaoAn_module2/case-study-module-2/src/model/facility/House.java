package model.facility;

import java.util.Objects;

public class House extends RentalService {
    private String standardRoom;
    private int numberOfRoom;


    public House() {
    }

    public House(String name, double area, double rentCost,
                 int numberOfPeople, String rentType, String standardRoom, int numberOfRoom) {
        super(name, area, rentCost, numberOfPeople, rentType);
        this.standardRoom = standardRoom;
        this.numberOfRoom = numberOfRoom;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        House house = (House) o;
        return numberOfRoom == house.numberOfRoom
                && Objects.equals(standardRoom, house.standardRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), standardRoom, numberOfRoom);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Tiêu chuẩn phòng : " + standardRoom + '\'' +
                ", Số phòng  : " + numberOfRoom +
                '}';
    }
}
