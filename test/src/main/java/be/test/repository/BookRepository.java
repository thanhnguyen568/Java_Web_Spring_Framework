package be.test.repository;

import be.test.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    @Query("update Book b set b.bookQuantity = :newQuantity")
    void DecreasedByHQL(@Param("newQuantity") Long newQuantity);
}
