package baitap.wmsnew.controller;

import baitap.wmsnew.entity.Customer;
import baitap.wmsnew.service.CustomerService;
import baitap.wmsnew.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/update-customer")
    public String showFormUpdate(@RequestParam Long customerNo, Model model) {
        model.addAttribute("customer", customerService.findByNo(customerNo));
        // Entity 2nd
        model.addAttribute("types", customerTypeService.findAll());
        return "/customer/update";
    }

    @PostMapping("/updated")
    public String update(Customer customer, RedirectAttributes redirect) {
        customerService.update(customer);
        redirect.addFlashAttribute("message", "update successfully!");
        return "redirect:/customers";
    }

    @PostMapping("/deleted")
    public String delete(@RequestParam("checkbox") long[] checkbox, Model model, RedirectAttributes redirect) {
        for (long no : checkbox) {
            customerService.remove(no);
            redirect.addFlashAttribute("message", "Removed successfully!");
        }
        return "redirect:/customers";
    }

    // Pageable phân trang
    @GetMapping("")
    public String display(
        @RequestParam(name = "page", required = false, defaultValue = "1") int page,
        @RequestParam(name = "size", required = false, defaultValue = "3") int size,
        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
        Model model) {
            Sort order = null;
            if (sort.equals("ASC")) {
                order = Sort.by("customerName").ascending();
            } else if (sort.equals("DESC")) {
                order = Sort.by("customerName").descending();
            }

            Pageable pageable = PageRequest.of(page - 1, size, order);
        model.addAttribute("customers", customerService.findAll(pageable));
        return "/customer/list";
    }

}
