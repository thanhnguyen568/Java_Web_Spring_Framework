package be.cms.service;

import be.cms.entity.Type;

import java.util.List;

public interface TypeService {
    List<Type> findAll();

    Type findByNo(Long typeNo);

    void save(Type type);

    void remove(Long typeNo);

}
