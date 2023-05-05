package be.test.service;

import be.test.entity.Book;
import be.test.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Book> listAll() {
        return (List<Book>) repository.findAll();
    }

    @Override
    public Book findByNo(Long bookNo) {
        return repository.findById(bookNo).orElse(null);
    }

    @Override
    public void changeQuantity(Long newQuantity) {
        repository.DecreasedByHQL(newQuantity);
    }

}
