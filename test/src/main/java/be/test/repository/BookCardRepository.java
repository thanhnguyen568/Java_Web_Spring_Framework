package be.test.repository;

import be.test.entity.BookCard;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCardRepository extends PagingAndSortingRepository<BookCard, Long> {
}
