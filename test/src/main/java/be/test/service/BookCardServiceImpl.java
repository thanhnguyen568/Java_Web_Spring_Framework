package be.test.service;

import be.test.entity.BookCard;
import be.test.repository.BookCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookCardServiceImpl implements BookCardService {
    @Autowired
    private BookCardRepository repository;

    @Override
    public BookCard findByNo(Long bookCardNo) {
        return repository.findById(bookCardNo).orElse(null);
    }

    @Override
    public void save(BookCard bookCard) {
        repository.save(bookCard);
    }

    @Override
    public void remove(Long bookCardNo) {
        repository.deleteById(bookCardNo);
    }

    @Override
    public Page<BookCard> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<BookCard> searchAll(String bookName, Pageable pageable) {
        return null;
    }
}
