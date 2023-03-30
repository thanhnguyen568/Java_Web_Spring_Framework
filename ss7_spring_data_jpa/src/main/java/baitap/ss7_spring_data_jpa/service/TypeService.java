package baitap.ss7_spring_data_jpa.service;

import baitap.ss7_spring_data_jpa.entity.Type;

import java.util.List;

public interface TypeService {
    List<Type> findAll();
}
