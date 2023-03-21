package baitap.wmsnew.controller;

import baitap.wmsnew.entity.Customer;
import baitap.wmsnew.service.CustomerService;
import baitap.wmsnew.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

//    @GetMapping("")
//    public String display(Model model) {
//        model.addAttribute("customers", customerService.findAll());
//        return "/customer/list";
//    }

    /**
     * Pageable
     */
    @GetMapping("")
    public String findAll(@PageableDefault(value = 5) Pageable pageable, Model model) {
        model.addAttribute("customers", customerService.findAll(pageable));
        return "/customer/list";
    }

    /**
     * Create
     */
    @GetMapping("/create-customer")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        // Entity 2nd
        model.addAttribute("types", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/created")
    public String created(@ModelAttribute Customer customer, Model model, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/customers";
    }

    /**
     * Update
     */
    @GetMapping("/update-customer")
    public String showFormUpdate(@RequestParam Long customerNo, Model model) {
        model.addAttribute("customer", customerService.findByNo(customerNo));
        // Entity 2nd
        model.addAttribute("types", customerTypeService.findAll());
        return "/customer/update";
    }

    @PostMapping("/updated")
    public String updated(Customer customer, RedirectAttributes redirect) {
        customerService.update(customer);
        redirect.addFlashAttribute("message", "update successfully!");
        return "redirect:/customers";
    }

    /**
     * Delete
     */
    @PostMapping("/deleted")
    public String deleted(@RequestParam("checkbox") long[] checkbox, Model model, RedirectAttributes redirect) {
        for (long no : checkbox) {
            customerService.remove(no);
            redirect.addFlashAttribute("message", "Removed successfully!");
        }
        return "redirect:/customers";
    }

    @GetMapping("search")
    public String search(@RequestParam("search") String input, Model model){
        model.addAttribute("customers", customerService.search(input));
        return "redirect:/customers";
    }
}
