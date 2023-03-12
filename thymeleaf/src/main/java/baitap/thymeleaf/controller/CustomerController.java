package baitap.thymeleaf.controller;

import baitap.thymeleaf.model.Customer;
import baitap.thymeleaf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirect) {
        customer.setCustomerNo((int) (Math.random() * 10000));
        customerService.create(customer);
        redirect.addFlashAttribute("success", "Add new success!");
        return "redirect:/customers";
    }

    @GetMapping("/{customerNo}/update")
    public String edit(@PathVariable int customerNo, Model model) {
        model.addAttribute("customer", customerService.findByNo(customerNo));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirect) {
        customerService.update(customer);
        redirect.addFlashAttribute("success", "update success!");
        return "redirect:/customers";
    }

    @GetMapping("/{customerNo}/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.delete(customer);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }
}
