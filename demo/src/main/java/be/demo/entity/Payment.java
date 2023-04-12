package be.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentNo;
    private String paymentName;
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<HomeStay> homeStays;

    public Payment() {
    }

    public Payment(long paymentNo, String paymentName, Set<HomeStay> homeStays) {
        this.paymentNo = paymentNo;
        this.paymentName = paymentName;
        this.homeStays = homeStays;
    }

    public long getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(long paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public Set<HomeStay> getHomeStays() {
        return homeStays;
    }

    public void setHomeStays(Set<HomeStay> homeStays) {
        this.homeStays = homeStays;
    }
}
