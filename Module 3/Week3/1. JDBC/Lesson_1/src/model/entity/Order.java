package model.entity;

import java.sql.Date;

public class Order {
    private int id;
    private Date dateTime;
    private int customerID;

    public Order() {
    }

    public Order(int id, Date dateTime, int customerID) {
        this.id = id;
        this.dateTime = dateTime;
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
