package be.demo.repository;

import be.demo.entity.HomeStay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeStayRepository extends PagingAndSortingRepository<HomeStay, Long> {
    Page<HomeStay> findAllByNameContainingOrPhoneContaining(String name, String phone,
                                                            Pageable pageable);
}
