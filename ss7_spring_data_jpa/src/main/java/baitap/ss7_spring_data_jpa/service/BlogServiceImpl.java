package baitap.ss7_spring_data_jpa.service;

import baitap.ss7_spring_data_jpa.entity.Blog;
import baitap.ss7_spring_data_jpa.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Blog> findAllWithPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
