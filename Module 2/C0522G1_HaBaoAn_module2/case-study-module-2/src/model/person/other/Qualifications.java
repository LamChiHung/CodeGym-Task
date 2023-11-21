package model.person.other;

public class Qualifications {
    private int id;
    private String name;

    public Qualifications() {
    }

    public Qualifications(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trình độ : " +
                "Mã trình độ : " + id +
                " Tên trình độ : " + name + '\'' +
                '}';
    }
}
