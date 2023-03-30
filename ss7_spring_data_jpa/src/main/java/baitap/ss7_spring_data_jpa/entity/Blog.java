package baitap.ss7_spring_data_jpa.entity;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_no")
    private long blogNo;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "type_no")
    private Type type;

    public Blog() {
    }

    public Blog(long blogNo, String title, String description) {
        this.blogNo = blogNo;
        this.title = title;
        this.description = description;
    }

    public long getBlogNo() {
        return blogNo;
    }

    public void setBlogNo(long blogNo) {
        this.blogNo = blogNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
