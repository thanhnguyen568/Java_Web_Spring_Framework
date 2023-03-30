package baitap.ss7_spring_data_jpa.service;

import baitap.ss7_spring_data_jpa.entity.Type;
import baitap.ss7_spring_data_jpa.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeRepository repository;
    @Override
    public List<Type> findAll() {
        return (List<Type>) repository.findAll();
    }
}
