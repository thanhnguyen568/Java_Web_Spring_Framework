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
    public String showFormCreate() {
        return "customer/create";
    }

    @PostMapping("/created")
    public String Created(@RequestParam
                          String customerNo,
                          String customerName,
                          String customerEmail,
                          String customerAddress,
                          Model model) {
        customerService.create(new Customer(customerNo, customerName, customerEmail, customerAddress));

        model.addAttribute("customers", customerService.findAll());
        return "redirect:/customers";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam String customerNo, Model model) {
        model.addAttribute("customer", customerService.findByNo(customerNo));
        return "customer/update";
    }

    @PostMapping("updated")
    public String updated(@RequestParam
                          String customerNo,
                          String customerName,
                          String customerEmail,
                          String customerAddress,
                          Model model) {
        customerService.create(new Customer(customerNo, customerName, customerEmail, customerAddress));

        model.addAttribute("customers", customerService.findAll());
        return "redirect:/customers";
    }

    @GetMapping("/")
    public String delete(@RequestParam("checkbox") String[] checkbox, Model model) {
        for (String o : checkbox) {
            System.out.println(o);
        }
        return "redirect:/customers";
    }
}
