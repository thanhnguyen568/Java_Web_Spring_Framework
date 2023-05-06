package erpmini.be.service;

import erpmini.be.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findWithPage(Pageable pageable);

    Book findByNo(Long bookNo);
}
