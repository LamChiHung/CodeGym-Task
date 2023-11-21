package model.person;

import java.util.Date;
import java.util.Objects;

public class Person {
    private String name;
    private Date dateOfBirth;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, Date dateOfBirth, String gender, String idCard, String phoneNumber, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName())
                && Objects.equals(getDateOfBirth(), person.getDateOfBirth())
                && Objects.equals(getGender(), person.getGender())
                && Objects.equals(getIdCard(), person.getIdCard())
                && Objects.equals(getPhoneNumber(), person.getPhoneNumber())
                && Objects.equals(getEmail(), person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDateOfBirth(), getGender(), getIdCard(), getPhoneNumber(), getEmail());
    }

    @Override
    public String toString() {
        return
                "Tên : " + name + '\'' +
                        ", Ngày sinh : " + dateOfBirth +
                        ", Giới tính : " + gender + '\'' +
                        ", Số CMND/CCCD :" + idCard + '\'' +
                        ", Số điện thoại :" + phoneNumber + '\'' +
                        ", Email :" + email + '\'' +
                        '}';
    }
}
