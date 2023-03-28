package baitap.wmsnew.service.impl;

import baitap.wmsnew.entity.CustomerType;
import baitap.wmsnew.repository.CustomerTypeRepository;
import baitap.wmsnew.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    private CustomerTypeRepository repository;

    @Override
    public List<CustomerType> findAll() {
        return (List<CustomerType>) repository.findAll();
    }
}
