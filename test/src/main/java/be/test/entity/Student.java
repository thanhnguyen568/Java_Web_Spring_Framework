package be.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentNo;
    private String studentName;
    private String studentClass;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BookCard> bookCards;

    @Override
    public String toString() {
        return studentName;
    }
}
