package baitap.ss8_validation.controller;

import baitap.ss8_validation.Service.UserService;
import baitap.ss8_validation.entity.User;
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
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String created(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "/user/create";
        }
        service.save(user);
        redirect.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/users";
    }
}
