package case_study.model.person;

public class Employee extends Person {
    private String employeeCode;
    private String literacy;
    private String position;
    private long salary;

    public Employee() {
    }

    public String getLiteracy() {
        return literacy;
    }

    public void setLiteracy(String literacy) {
        this.literacy = literacy;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employee(String employeeCode,
                    String name,
                    String dateOfBirth,
                    String gender,
                    long id,
                    int phoneNumber,
                    String email,
                    String literacy,
                    String position,
                    long salary) {
        super(name, dateOfBirth, gender, id, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.position = position;
        this.salary = salary;
        this.literacy = literacy;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                getEmployeeCode(),
                getName(),
                getDateOfBirth(),
                getGender(),
                getId(),
                getPhoneNumber(),
                getEmail(),
                getLiteracy(),
                getPosition(),
                getSalary());
    }

    @Override
    public String toString() {
        return " Mã nhân viên: " + employeeCode + "," +
                super.toString() + "," +
                " Trình độ: " + literacy + "," +
                " Chức Vụ: " + position + "," +
                " Lương: " + salary;
    }


}
