package be.ss12ajax.controller;


import be.ss12ajax.model.Blog;
import be.ss12ajax.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {
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

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam("search") String search) {
        System.out.println(search);
        List<Blog> blogs = blogService.search(search, search);
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
