package baitap.wmsnew.controller;

import baitap.wmsnew.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("customers", service.findAll());
        return "/customer/list";
    }
}
