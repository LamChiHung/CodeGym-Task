package model.person;

import java.util.Date;
import java.util.Objects;

public class Employee extends Person {
    private String employeeCode;
    private String qualifications;
    private String position;
    private String salary;

    public Employee() {
    }

    public Employee(String name, Date dateOfBirth, String gender, String idCard, String phoneNumber,
                    String email, String employeeCode, String qualifications, String position, String salary) {
        super(name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.qualifications = qualifications;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeCode, employee.employeeCode)
                && Objects.equals(qualifications, employee.qualifications)
                && Objects.equals(position, employee.position)
                && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeCode, qualifications, position, salary);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Mã nhân viên :" + employeeCode + '\'' +
                ", Trình độ : " + qualifications + '\'' +
                ", Vị trí : " + position + '\'' +
                ", Lương : " + salary + '\'' +
                '}';
    }
}
