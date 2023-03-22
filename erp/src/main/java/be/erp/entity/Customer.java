package be.erp.entity;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "long")
    private long customerNo;
    private String customerCode;
    private String customerCreateDate;
    private String customerName;
    private String customerAddress;
    private String customerDateOfBirth;
    private String customerTel;
    private String customerEmail;
    private String customerDeliveryAddress;
    @ManyToOne
    @JoinColumn(name = "type_no")
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(long customerNo, String customerCode, String customerCreateDate, String customerName,
                    String customerAddress, String customerDateOfBirth, String customerTel, String customerEmail,
                    String customerDeliveryAddress, CustomerType customerType) {
        this.customerNo = customerNo;
        this.customerCode = customerCode;
        this.customerCreateDate = customerCreateDate;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerTel = customerTel;
        this.customerEmail = customerEmail;
        this.customerDeliveryAddress = customerDeliveryAddress;
        this.customerType = customerType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public long getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(long customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCreateDate() {
        return customerCreateDate;
    }

    public void setCustomerCreateDate(String customerCreateDate) {
        this.customerCreateDate = customerCreateDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
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

    public String getCustomerDeliveryAddress() {
        return customerDeliveryAddress;
    }

    public void setCustomerDeliveryAddress(String customerDeliveryAddress) {
        this.customerDeliveryAddress = customerDeliveryAddress;
    }
}
