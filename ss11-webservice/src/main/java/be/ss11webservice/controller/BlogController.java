package be.ss11webservice.controller;


import be.ss11webservice.model.Blog;
import be.ss11webservice.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAll() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Blog[] blog) {
//        Student student = new Student();
//        student.setId(studentForm.getId());
//        student.setName(studentForm.getName());
//        student.setBirthdate(studentForm.getBirthdate());
//        student.setEmail(studentForm.getEmail());
//        student.setSex(studentForm.isSex());
//        student.setPhoneNumber(studentForm.getPhoneNumber());
//        student.setClassName(classNameService.findById(studentForm.getClassId()));
        for (Blog b : blog) {
            blogService.save(b);
        }
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
