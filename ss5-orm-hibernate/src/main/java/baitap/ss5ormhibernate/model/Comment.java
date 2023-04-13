package baitap.ss5ormhibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    private long score;
    private String author;
    private String feedback;
    private Date date;

    public Comment() {
    }

    public Comment(long no, long score, String author, String feedback) {
        this.no = no;
        this.score = score;
        this.author = author;
        this.feedback = feedback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "no=" + no +
                ", author='" + author + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
