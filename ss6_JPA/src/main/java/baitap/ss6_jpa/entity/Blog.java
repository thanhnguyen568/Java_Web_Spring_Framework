package baitap.ss6_jpa.entity;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_no")
    private long blogNo;
    private String title;
    private String description;

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
}
