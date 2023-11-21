package case_study.model;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getServiceID(),
                getName(),
                getArea(),
                getRentalCost(),
                getMaxNumberOfPeople(),
                getRentalType(),
                getFreeService());
    }

    public Room(String serviceID,
                String name,
                double area,
                double rentalCost,
                int maxNumberOfPeople,
                String rentalType,
                String freeService) {
        super(name, serviceID, area, rentalCost, maxNumberOfPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return " Phòng: " +
                super.toString() +
                " Dịch vụ miễn phí đi kèm: " + freeService;
    }
}