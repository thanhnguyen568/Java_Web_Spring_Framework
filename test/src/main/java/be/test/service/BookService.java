package be.test.service;

import be.test.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Page<Book> findAll(Pageable pageable);
    Book findByNo(Long bookNo);
}
