package baitap.ss8_validation.Service;

import baitap.ss8_validation.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
}
