package be.cms.service;

import be.cms.entity.Type;
import be.cms.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository repository;

    @Override
    public List<Type> findAll() {
        return (List<Type>) repository.findAll();
    }

    @Override
    public Type findByNo(Long typeNo) {
        return null;
    }

    @Override
    public void save(Type type) {

    }

    @Override
    public void remove(Long typeNo) {

    }
}
