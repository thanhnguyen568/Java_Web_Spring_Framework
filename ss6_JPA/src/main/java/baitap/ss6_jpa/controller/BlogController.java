package baitap.ss6_jpa.controller;

import baitap.ss6_jpa.entity.Blog;
import baitap.ss6_jpa.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService service;

    @GetMapping("")
    public String display(Model model){
        model.addAttribute("blogs",service.findAll());
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
