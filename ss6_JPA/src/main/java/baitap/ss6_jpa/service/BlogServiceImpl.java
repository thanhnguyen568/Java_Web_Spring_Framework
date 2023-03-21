package baitap.ss6_jpa.service;

import baitap.ss6_jpa.entity.Blog;
import baitap.ss6_jpa.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository repository;

    @Override
    public List<Blog> findAll() {
        Iterable<Blog> iterable = repository.findAll();
        List<Blog> blogList = new ArrayList<>();
        for (Blog b : iterable) {
            blogList.add(b);
        }
        return blogList;
    }

    @Override
    public Blog findByNo(long blogNo) {
        return repository.findById(blogNo).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void remove(long blogNo) {
        repository.deleteById(blogNo);
    }
}
