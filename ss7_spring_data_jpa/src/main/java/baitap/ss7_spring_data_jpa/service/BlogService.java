package baitap.ss7_spring_data_jpa.service;

import baitap.ss7_spring_data_jpa.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findByNo(long blogNo);

    void save(Blog blog);

    void update(Blog blog);

    void remove(long blogNo);

    Page<Blog> findAllWithPaging(Pageable pageable);

}
