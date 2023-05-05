package be.test.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookCardNo;
    @ManyToOne
    @JoinColumn(name = "book_no")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "student_no")
    private Student student;
//    @Column(columnDefinition = "boolean default Đang mượn sách")
    private boolean status;
    private Date dateOfBorrow;
    private Date dateOfPay;

}
