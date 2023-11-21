package model.person;

import java.util.Date;
import java.util.Objects;

public class Customer extends Person {
    private String customerCode;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, Date dateOfBirth, String gender, String idCard,
                    String phoneNumber, String email, String customerCode, String customerType, String address) {
        super(name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerCode, customer.customerCode)
                && Objects.equals(customerType, customer.customerType)
                && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerCode, customerType, address);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Mã khách hàng : " + customerCode + '\'' +
                ", Loại khách : " + customerType + '\'' +
                ", Địa chỉ : " + address + '\'';
    }
}
