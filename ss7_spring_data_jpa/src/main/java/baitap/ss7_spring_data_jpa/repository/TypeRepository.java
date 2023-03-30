package baitap.ss7_spring_data_jpa.repository;

import baitap.ss7_spring_data_jpa.entity.Type;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends PagingAndSortingRepository<Type, Long> {
}
