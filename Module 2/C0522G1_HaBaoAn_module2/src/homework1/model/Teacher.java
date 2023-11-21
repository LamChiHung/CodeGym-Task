package homework1.model;

public class Teacher extends Person {
    private String specialize;

    public Teacher() {
    }

    public Teacher(int id, String name, String dayOfBirth, String gender, String specialize) {
        super(id, name, dayOfBirth, gender);
        this.specialize = specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return "Giáo viên{" +
                "ID: " + getId() +
                ", Tên: " + getName() +
                ", Ngày sinh: " + getDayOfBirth() +
                ", Giới tính: " + getGender() +
                ", Chuyên môn: '" + getSpecialize();
    }
}
