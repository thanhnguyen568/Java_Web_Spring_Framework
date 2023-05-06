package be.wms.controller;

import be.wms.entity.Customer;
import be.wms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("customers", service.findAll());
        return "/customer/list";
    }

    @GetMapping("/create-customer")
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

    @GetMapping("/update-customer")
    public String showFormUpdate(@RequestParam String customerNo, Model model) {
        model.addAttribute("customer", service.findByNo(customerNo));
        return "/customer/update";
    }

    @PostMapping("/updated")
    public String update(Customer customer, RedirectAttributes redirect) {
        service.update(customer);
        redirect.addFlashAttribute("message", "update successfully!");
        return "redirect:/customers";
    }

    @PostMapping("/deleted")
    public String delete(@RequestParam("checkbox") String[] checkbox, Model model, RedirectAttributes redirect) {
        for (String o : checkbox) {
            service.delete(service.findByNo(o));
            redirect.addFlashAttribute("message", "Removed successfully!");
        }
        return "redirect:/customers";
    }

//    @GetMapping("/{customerNo}/delete")
//    public String delete(@ModelAttribute Customer customer, RedirectAttributes redirect) {
//        service.delete(customer);
//        redirect.addFlashAttribute("message", "Removed successfully!");
//        return "redirect:/customers";
//    }
}

