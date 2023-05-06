package erpmini.be.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerNo;

    @Pattern(regexp = "KH-\\d{4}", message = "{code}")
    private String customerCode;

    private Date customerCreateDate;

    @Size(min = 5, max = 50)
    @Pattern(regexp = "[^!@#$%^&*()_+=0-9-]*", message = "{name}")
    private String customerName;

    @NotBlank
    private String customerAddress;

    //    @PastOrPresent(message = "{pastOrPresent}")
    private Date customerDateOfBirth;

    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "{tel}")
    private String customerTel;

    @Email(message = "{email}")
    private String customerEmail;

    @NotBlank
    private String customerDeliveryAddress;

    @ManyToOne
    @JoinColumn(name = "type_no")
    private TypeCustomer typeCustomer;

    public Customer() {
    }

    public Customer(long customerNo, String customerCode, Date customerCreateDate, String customerName,
                    String customerAddress, Date customerDateOfBirth, String customerTel, String customerEmail,
                    String customerDeliveryAddress, TypeCustomer typeCustomer) {
        this.customerNo = customerNo;
        this.customerCode = customerCode;
        this.customerCreateDate = customerCreateDate;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerTel = customerTel;
        this.customerEmail = customerEmail;
        this.customerDeliveryAddress = customerDeliveryAddress;
        this.typeCustomer = typeCustomer;
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

    public Date getCustomerCreateDate() {
        return customerCreateDate;
    }

    public void setCustomerCreateDate(Date customerCreateDate) {
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

    public Date getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(Date customerDateOfBirth) {
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

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
}
