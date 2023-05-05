package be.test.service;

import be.test.entity.Student;
import be.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository repository;
    @Override
    public List<Student> listAll() {
        return (List<Student>) repository.findAll();
    }
}
