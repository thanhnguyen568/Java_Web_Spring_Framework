package be.test.service;

import be.test.entity.BookCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookCardService {
    BookCard findByNo(Long bookCardNo);

    void save(BookCard bookCard);

    void update(Long bookCardNo);

    Page<BookCard> findAll(Pageable pageable);

}
