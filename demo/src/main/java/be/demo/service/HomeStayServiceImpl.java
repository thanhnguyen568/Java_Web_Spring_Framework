package be.demo.service;

import be.demo.entity.HomeStay;
import be.demo.repository.HomeStayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HomeStayServiceImpl implements HomeStayService {
    @Autowired
    private HomeStayRepository repository;
    @Override
    public HomeStay findByNo(Long no) {
        return repository.findById(no).orElse(null);
    }

    @Override
    public void save(HomeStay homeStay) {
        repository.save(homeStay);
    }

    @Override
    public void remove(Long no) {
        repository.deleteById(no);
    }

    @Override
    public Page<HomeStay> findAllWithPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<HomeStay> searchAllWithPage(String name, String phone, Pageable pageable) {
        return repository.findAllByNameContainingOrPhoneContaining(name,phone,pageable);
    }

    @Override
    public HomeStay findByNoContaining(String no) {
        return null;
    }
}
