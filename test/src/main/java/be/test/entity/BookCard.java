package be.test.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
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

    @Pattern(regexp = "MS-\\d{4}", message = "{code}")
    private String bookCardCode;

    @ManyToOne
    @JoinColumn(name = "book_no")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "student_no")
    private Student student;

    private boolean status;

    private Date dateOfBorrow;

    private Date dateOfPay;

    public Date getDateOfBorrow() {
        long millis = System.currentTimeMillis();
        return new Date(millis);
    }

}
