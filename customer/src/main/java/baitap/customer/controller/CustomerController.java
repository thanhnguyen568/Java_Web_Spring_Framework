package baitap.customer.controller;

import baitap.customer.model.Customer;
import baitap.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("customer/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    public String displayList(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/list";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        return "customer/create";
    }

    @PostMapping("result")
    public String create(@RequestParam String customerNo,
                         @RequestParam String customerName,
                         @RequestParam String customerEmail,
                         @RequestParam String customerAddress,
                         @RequestParam Model model) {
        Customer customer = new Customer(customerNo, customerName, customerEmail, customerAddress);
        customerService.create(customer);
        model.addAttribute("customers", customerService.findAll());
        return "/customer/list";
    }
}
