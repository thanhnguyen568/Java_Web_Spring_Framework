package erpmini.be.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardNo;
    @Pattern(regexp = "MS-\\d{4}", message = "{code}")
    private String cardCode;
    private boolean status;
    private Date dateOfBorrow;
    private Date dateOfPay;
    @ManyToOne
    @JoinColumn(name = "book_no")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "student_no")
    private Student student;

    public Date getDateOfBorrow() {
        long millis = System.currentTimeMillis();
        return new Date(millis);
    }

}
