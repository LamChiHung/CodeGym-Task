package case_study.model.person;

public abstract class Person {

    private String name;
    private String dateOfBirth;
    private String gender;
    private long id;
    private long phoneNumber;
    private String email;


    public Person() {
    }

    public Person(String name,
                  String dateOfBirth,
                  String gender,
                  long id,
                  long phoneNumber,
                  String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return
                " Tên:  " + name + "," +
                        " Ngày sinh:  " + dateOfBirth + "," +
                        " Giới tính: " + gender + "," +
                        " CMND/Căn cước: " + id + "," +
                        " Số điện thoại: " + phoneNumber + "," +
                        " Email: " + email + "+";

    }
}
