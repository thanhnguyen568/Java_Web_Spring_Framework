package be.wms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @Column(columnDefinition = "varchar(10)")
    private String customerNo;
    private String customerName;
    private String customerBirthDay;
    private String customerTel;
    private String customerEmail;
    private String customerAddress;
    private String customerDeliveryAddress;
    private String customerTaxIndent;

    public Customer() {
    }

    public Customer(String customerNo, String customerName, String customerBirthDay, String customerTel, String customerEmail, String customerAddress, String customerDeliveryAddress, String customerTaxIndent) {
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerTel = customerTel;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerDeliveryAddress = customerDeliveryAddress;
        this.customerTaxIndent = customerTaxIndent;
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

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
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

    public String getCustomerDeliveryAddress() {
        return customerDeliveryAddress;
    }

    public void setCustomerDeliveryAddress(String customerDeliveryAddress) {
        this.customerDeliveryAddress = customerDeliveryAddress;
    }

    public String getCustomerTaxIndent() {
        return customerTaxIndent;
    }

    public void setCustomerTaxIndent(String customerTaxIndent) {
        this.customerTaxIndent = customerTaxIndent;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNo='" + customerNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerBirthDay='" + customerBirthDay + '\'' +
                ", customerTel='" + customerTel + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerDeliveryAddress='" + customerDeliveryAddress + '\'' +
                ", customerTaxIndent='" + customerTaxIndent + '\'' +
                '}';
    }
}
