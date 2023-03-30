package baitap.ss8_validation.service;

import baitap.ss8_validation.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
}
