package model.facility;

import java.util.Objects;

public class Room extends RentalService {
    private String freeService;

    public Room() {
    }

    public Room(String name, double area, double rentCost, int numberOfPeople, String rentType, String freeService) {
        super(name, area, rentCost, numberOfPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return Objects.equals(freeService, room.freeService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), freeService);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Dịch vụ miễn phí đi kèm : '" + freeService + '\'' +
                '}';
    }
}
