package baitap.baitap.controller;

import baitap.baitap.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("email")
public class EmailController {
    public String[] languages = new String[]{"English","Vietnamese", "Japanese", "Chinese"};
    public int[] pages = new int[]{5, 10, 15, 25, 50, 100};

    @GetMapping()
    public String getHome(Model model){
        Email email = new Email();
        model.addAttribute("email", email);
        model.addAttribute("languages", languages);
        model.addAttribute("pages", pages);
        return "information";
    }

    @PostMapping()
    public String save(Model model, @ModelAttribute Email email, RedirectAttributes rd){
        System.out.println(email);
        model.addAttribute("email",email);
        model.addAttribute("languages", languages);
        model.addAttribute("pages", pages);
        rd.addFlashAttribute("message","Settings have been saved");
        return "redirect:/email";
    }
}
