package case_study.model;

public abstract class Facility {
    private String name;
    private String serviceID;
    private double area;
    private double rentalCost;
    private int maxNumberOfPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility( String serviceID,String name, double area, double rentalCost, int maxNumberOfPeople, String rentalType) {
        this.name = name;
        this.serviceID = serviceID;
        this.area = area;
        this.rentalCost = rentalCost;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.rentalType = rentalType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return " Mã dịch vụ: " + serviceID +
                "Tên dịch vụ: " + name + '\'' +
                " Diện tích sử dụng: " + area +
                " Chi phí thuê: " + rentalCost +
                " Số lượng người tối đa: " + maxNumberOfPeople +
                " Kiểu thuê: '" + rentalType;
    }
}
