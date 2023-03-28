package be.cms.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerNo;
    @NotEmpty
    @Pattern(regexp = "KH-\\d{4}", message = "{code}")
    private String customerCode;
    @NotEmpty
    private String customerCreateDate;
    @NotEmpty
    @Pattern(regexp = "\\w", message = "{name}")
    @Size(min = 5, max = 50)
    private String customerName;
    @NotEmpty
    private String customerAddress;
    @NotEmpty
    private String customerDateOfBirth;
    @NotEmpty
    private String customerTel;
    @NotEmpty
    @Email(message = "{email}")
    private String customerEmail;
    @NotEmpty
    private String customerDeliveryAddress;

    @ManyToOne
    @JoinColumn(name = "type_no")
    private Type type;

    public Customer() {
    }

    public Customer(long customerNo, String customerCode, String customerCreateDate, String customerName,
                    String customerAddress, String customerDateOfBirth, String customerTel, String customerEmail,
                    String customerDeliveryAddress, Type type) {
        this.customerNo = customerNo;
        this.customerCode = customerCode;
        this.customerCreateDate = customerCreateDate;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerTel = customerTel;
        this.customerEmail = customerEmail;
        this.customerDeliveryAddress = customerDeliveryAddress;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
