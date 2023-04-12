package be.ss11webservice.service;


import be.ss11webservice.model.Type;
import be.ss11webservice.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeRepository repository;

    @Override
    public Iterable<Type> findAll() {
        return repository.findAll();
    }

    @Override
    public Type findById(Long id) {
        return null;
    }

    @Override
    public Type save(Type type) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Type> findAllWithPaging(Pageable pageable) {
        return null;
    }
}
