package be.erp.service.impl;

import be.erp.entity.CustomerType;
import be.erp.repository.CustomerTypeRepository;
import be.erp.service.CustomerTypeService;
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
