package model.contract;

public class Contract {
    private int numberContract;
    private String bookingCode;
    private String deposit;
    private String payments;
    private String customerCode;

    public Contract() {
    }

    public Contract(int numberContract, String bookingCode, String deposit, String payments, String customerCode) {
        this.numberContract = numberContract;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.payments = payments;
        this.customerCode = customerCode;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numberContract=" + numberContract +
                ", bookingCode='" + bookingCode + '\'' +
                ", deposit='" + deposit + '\'' +
                ", payments='" + payments + '\'' +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
