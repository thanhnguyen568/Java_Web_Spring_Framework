package baitap.customer.model;

import org.springframework.stereotype.Component;

public class Customer {
    private String customerNo;
    private String customerName;
    private String customerEmail;
    private String customerAddress;

    public Customer() {
    }

    public Customer(String customerNo, String customerName, String customerEmail, String customerAddress) {
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
