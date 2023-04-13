package baitap.ss5ormhibernate.controller;

import baitap.ss5ormhibernate.model.Comment;
import baitap.ss5ormhibernate.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService service;

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("comments", service.findAll());
        model.addAttribute("comment", new Comment());
        return "/comment/list";
    }


    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("customer") Comment comment, BindingResult bindingResult, Model model
            , RedirectAttributes redirect) {
        service.save(comment);
        redirect.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/comments";
    }
}
