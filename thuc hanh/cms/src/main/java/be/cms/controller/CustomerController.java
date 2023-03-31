package be.cms.controller;

import be.cms.entity.Customer;
import be.cms.service.CustomerService;
import be.cms.service.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    TypeServiceImpl typeService;

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
        return "/customer/listPaging";
    }

    /**
     * Search
     */
    @GetMapping("search")
    public String search(@RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size,
                         @RequestParam("search") String input,
                         Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Sort sort = Sort.by("customerName").ascending();

        model.addAttribute("search", input);
        Page<Customer> customerPage = customerService.searchAll(input, input, PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("customers", customerPage);
        return "/customer/listPaging";
    }

//    @GetMapping("search")
//    public String search(@RequestParam("search") String input, Model model) {
//        model.addAttribute("search", input);
//        model.addAttribute("customers", customerService.findAllBySearch(input, input, input));
//        return "/customer/list";
//    }

    /**
     * Create
     */
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());

        // Entity 2nd
        model.addAttribute("types", typeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String created(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model
            , RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            // Entity 2nd
            model.addAttribute("types", typeService.findAll());
            return "/customer/create";
        }
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/customers";
    }

    /**
     * Update
     */
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam Long customerNo, Model model) {
        model.addAttribute("customer", customerService.findByNo(customerNo));

        // Entity 2nd
        model.addAttribute("types", typeService.findAll());
        return "/customer/update";
    }

    @PostMapping("/update")
    public String updated(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "update successfully!");
        return "redirect:/customers";
    }

    /**
     * Delete
     */
    @PostMapping("/delete")
    public String deleted(@RequestParam("checkbox") long[] checkbox, Model model, RedirectAttributes redirect) {
        for (long no : checkbox) {
            customerService.remove(no);
            redirect.addFlashAttribute("message", "Removed successfully!");
        }
        return "redirect:/customers";
    }

    @GetMapping("/delete")
    public String deleted(@RequestParam Long customerNo, Model model, RedirectAttributes redirect) {
        customerService.remove(customerNo);
        redirect.addFlashAttribute("message", "Removed successfully!");
        return "redirect:/customers";

    }
}
