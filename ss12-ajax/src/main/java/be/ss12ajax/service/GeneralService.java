package be.ss12ajax.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneralService<T> {
    Iterable<T> findAll();

    T findById(Long id);

    T save(T t);

    void remove(Long id);

    Page<T> findAllWithPaging(Pageable pageable);

}
