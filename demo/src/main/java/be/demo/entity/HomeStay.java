package be.demo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class HomeStay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    private String name;
    private String phone;
    private Date rentDate;

    @ManyToOne
    @JoinColumn(name = "payment_no")
    private Payment payment;

    public HomeStay() {
    }

    public HomeStay(long no, String name, String phone, Date rentDate, Payment payment) {
        this.no = no;
        this.name = name;
        this.phone = phone;
        this.rentDate = rentDate;
        this.payment = payment;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
