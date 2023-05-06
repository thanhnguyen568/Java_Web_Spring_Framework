package be.cms.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long typeNo;
    private String typeName;
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Customer> customers;

    public Type() {
    }

    public Type(long typeNo, String typeName, Set<Customer> customers) {
        this.typeNo = typeNo;
        this.typeName = typeName;
        this.customers = customers;
    }

    public long getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(long typeNo) {
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
