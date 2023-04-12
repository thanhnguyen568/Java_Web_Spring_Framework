package be.demo.service;

import be.demo.entity.HomeStay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HomeStayService {
    HomeStay findByNo(Long no);

    void save(HomeStay homeStay);

    void remove(Long no);

//    List<HomeStay> findAll();

    Page<HomeStay> findAllWithPaging(Pageable pageable);

//    List<HomeStay> searchAll(String customerName, String customerAddress, String customerTel);

    Page<HomeStay> searchAllWithPage(String name, String phone, Pageable pageable);

    //    Check duplicate code
    HomeStay findByNoContaining(String no);
}
