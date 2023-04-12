package be.ss11webservice.service;

import be.ss11webservice.model.Blog;
import be.ss11webservice.repository.BlogRepository;
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
        List<Blog> list = new ArrayList<>();
        for (Blog c : iterable) {
            list.add(c);
        }
        return list;
    }

    @Override
    public Blog findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Blog save(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllWithPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
