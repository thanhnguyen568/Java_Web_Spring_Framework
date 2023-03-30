package baitap.ss7_spring_data_jpa.controller;

import baitap.ss7_spring_data_jpa.entity.Blog;
import baitap.ss7_spring_data_jpa.service.BlogService;
import baitap.ss7_spring_data_jpa.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService service;

    @Autowired
    TypeService typeService;
//    @GetMapping("")
//    public String display(Model model){
//        model.addAttribute("blogs",service.findAll());
//        return "/blog/list";
//    }

    @GetMapping("")
    public String listPageSort(@RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size,
//                               @RequestParam("sort") Optional<String> sort,
                               Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Sort sort = Sort.by("blogNo").ascending();
        Page<Blog> blogs = service.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }
    @GetMapping("create-blog")
    public String showFormCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("created")
    public String created(@ModelAttribute Blog blog, RedirectAttributes redirect){
        service.save(blog);
        redirect.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/blogs";
    }


}
