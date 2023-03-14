package be.wms.controller;

import be.wms.model.Customer;
import be.wms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("")
    public String display(Model model) {
        List<Customer> customerList = service.findAll();
        model.addAttribute("customers", customerList);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/created")
    public String created(@ModelAttribute Customer customer, Model model, RedirectAttributes redirect) {
        service.create(customer);
        redirect.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{customerNo}/update")
    public String showFormUpdate(@PathVariable String customerNo, Model model) {
        model.addAttribute("customer", service.findByNo(customerNo));
        return "/customer/update";
    }

    @PostMapping("/updated")
    public String update(Customer customer, RedirectAttributes redirect) {
        service.update(customer);
        redirect.addFlashAttribute("message", "update successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{customerNo}/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        service.delete(customer);
        redirect.addFlashAttribute("message", "Removed successfully!");
        return "redirect:/customers";
    }
}
