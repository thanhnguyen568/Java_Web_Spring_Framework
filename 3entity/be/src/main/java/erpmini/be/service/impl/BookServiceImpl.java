package erpmini.be.service.impl;

import erpmini.be.entity.Book;
import erpmini.be.repository.BookRepository;
import erpmini.be.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repository;

    @Override
    public Page<Book> findWithPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Book findByNo(Long bookNo) {
        return repository.findById(bookNo).orElse(null);
    }
}
