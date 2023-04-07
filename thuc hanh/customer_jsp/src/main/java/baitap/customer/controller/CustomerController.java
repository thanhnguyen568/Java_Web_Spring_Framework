package baitap.customer.controller;

import baitap.customer.model.Customer;
import baitap.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String displayList(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/created")
    public String Created(@ModelAttribute Customer customer, Model model) {
        customerService.create(customer);
        return "redirect:/customers";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("customerNo") String customerNo, Model model) {
        model.addAttribute("customer", customerService.findByNo(customerNo));
        return "customer/update";
    }

    @PostMapping("updated")
    public String updated(@ModelAttribute Customer customer, Model model) {
        customerService.update(customer);
        return "redirect:/customers";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("checkbox") String[] checkbox, Model model) {
        for (String o : checkbox) {
            customerService.delete(customerService.findByNo(o));
        }
        return "redirect:/customers";
    }


    public String search(@RequestParam String search, Model model) {
        return "redirect:/customers";
    }
}
