package baitap.ss6_jpa.service;

import baitap.ss6_jpa.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findByNo(long blogNo);

    void save(Blog blog);

    void update(Blog blog);

    void remove(long blogNo);


}
