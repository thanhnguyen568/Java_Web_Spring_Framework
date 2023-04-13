package baitap.ss5ormhibernate.service;

import baitap.ss5ormhibernate.model.Comment;
import baitap.ss5ormhibernate.repositpry.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository repository;

    @Override
    public Comment findById(Long no) {
        return repository.findById(no).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void remove(Long no) {
        repository.deleteById(no);
    }

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) repository.findAll();
    }

    @Override
    public Comment findByCustomerCodeContaining(String customerCode) {
        return null;
    }
}
