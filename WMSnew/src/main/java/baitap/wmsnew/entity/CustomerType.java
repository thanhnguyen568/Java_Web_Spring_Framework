package baitap.wmsnew.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "types")
public class CustomerType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long typeNo;

    private String typeName;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Customer> customers;


    public CustomerType() {
    }

    public CustomerType(Long typeNo, String typeName, Set<Customer> customers) {
        this.typeNo = typeNo;
        this.typeName = typeName;
        this.customers = customers;
    }

    public Long getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(Long typeNo) {
        this.typeNo = typeNo;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

}
