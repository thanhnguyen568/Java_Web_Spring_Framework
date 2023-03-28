package be.erp.controller;

import be.erp.entity.Customer;
import be.erp.service.CustomerService;
import be.erp.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
//
//    @GetMapping("")
//    public String listPage(@PageableDefault(value = 1) Pageable pageable, Model model) {
//        model.addAttribute("customers", customerService.findAllWithPaging(pageable));
//        return "/customer/list";
//    }

    /**
     * Paging & Sorting
     */
    @GetMapping("")
    public String listPageSort(@RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size,
//                               @RequestParam("sort") Optional<String> sort,
                               Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Sort sort = Sort.by("customerName").ascending();
        Page<Customer> customers = customerService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("customers", customers);
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
    public String search(@RequestParam("search") String input, Model model) {
        model.addAttribute("customers", customerService.search(input));
        return "redirect:/customers";
    }
}
