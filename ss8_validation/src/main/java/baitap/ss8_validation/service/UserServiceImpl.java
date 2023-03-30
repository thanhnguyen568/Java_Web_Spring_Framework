package baitap.ss8_validation.service;

import baitap.ss8_validation.entity.User;
import baitap.ss8_validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
