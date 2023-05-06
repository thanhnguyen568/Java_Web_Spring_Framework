package erpmini.be.repository;

import erpmini.be.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CardRepository extends PagingAndSortingRepository<Card, Long> {
    @Transactional
    @Modifying
    @Query("update Card set status = true where cardNo = :cardNo")
    void updateByHQL(@Param("cardNo") Long cardNo);

    // @Query("Select c from Card c where c.status like %:status%")
    @Query("Select c from Card c where c.status = false ")
    Page<Card> findByHQL(Pageable pageable);
}
