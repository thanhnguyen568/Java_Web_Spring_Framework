package erpmini.be.service.impl;

import erpmini.be.entity.Student;
import erpmini.be.repository.StudentRepository;
import erpmini.be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) repository.findAll();
    }
}
