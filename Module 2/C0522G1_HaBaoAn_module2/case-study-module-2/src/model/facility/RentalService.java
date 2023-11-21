package model.facility;

import java.util.Objects;

public class RentalService {
    private String name;
    private double area;
    private double rentCost;
    private int numberOfPeople;
    private String rentType;

    public RentalService() {
    }

    public RentalService(String name, double area, double rentCost, int numberOfPeople, String rentType) {
        this.name = name;
        this.area = area;
        this.rentCost = rentCost;
        this.numberOfPeople = numberOfPeople;
        this.rentType = rentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalService that = (RentalService) o;
        return Double.compare(that.area, area) == 0
                && Double.compare(that.rentCost, rentCost) == 0
                && numberOfPeople == that.numberOfPeople
                && Objects.equals(name, that.name)
                && Objects.equals(rentType, that.rentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area, rentCost, numberOfPeople, rentType);
    }

    @Override
    public String toString() {
        return "Dịch vụ cho thuê : " +
                "Tên: '" + name + '\'' +
                ", Diện tích : " + area +
                ", Giá thuê : " + rentCost +
                ", Số người tối đa : " + numberOfPeople +
                ", Kiểu thuê :'" + rentType + '\'' +
                '}';
    }
}
