package be.test.repository;

import be.test.entity.BookCard;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookCardRepository extends PagingAndSortingRepository<BookCard, Long> {
    @Transactional
    @Modifying
    @Query("update BookCard set status = true where bookCardNo = :bookCardNo")
    void updateByHQL(@Param("bookCardNo") Long bookCardNo);
}



