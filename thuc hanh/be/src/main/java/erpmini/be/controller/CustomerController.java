package erpmini.be.controller;

import erpmini.be.entity.Customer;
import erpmini.be.entity.TypeCustomer;
import erpmini.be.service.CustomerService;
import erpmini.be.service.TypeCustomerService;
import erpmini.be.validate.CustomerValidate;
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
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TypeCustomerService typeService;
    @Autowired
    private CustomerValidate customerValidate;

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
        Sort sort = Sort.by("customerNo").ascending().and(Sort.by("customerCode").descending());

        Page<Customer> customers = customerService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("customers", customers);
        return "/customer/listPaging";
    }

    /**
     * Search & Paging
     */
    @GetMapping("search")
    public String searchPageSort(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size,
                                 @RequestParam("search") String input,
                                 Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Sort sort = Sort.by("customerNo").ascending().and(Sort.by("customerCode").ascending());

        model.addAttribute("search", input);
        Page<Customer> customerPage = customerService.searchAllWithPage(input, input, PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("customers", customerPage);
        return "/customer/listPaging";
    }

//    @GetMapping("search")
//    public String search(@RequestParam("search") String input, Model model) {
//        model.addAttribute("search", input);
//        model.addAttribute("customers", customerService.searchAll(input, input, input));
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
    public String doCreate(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model
            , RedirectAttributes redirect) {
        customerValidate.validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            // Entity 2nd
            model.addAttribute("types", typeService.findAll());
            if (customer.getTypeCustomer() == null) {
                customer.setTypeCustomer(new TypeCustomer());
            }
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
    public String doUpdate(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "update successfully!");
        return "redirect:/customers";
    }

    /**
     * Delete
     */
    @PostMapping("/delete")
    public String doDelete(@RequestParam("checkbox") long[] checkbox, Model model, RedirectAttributes redirect) {
        for (long no : checkbox) {
            customerService.remove(no);
            redirect.addFlashAttribute("message", "Removed successfully!");
        }
        return "redirect:/customers";
    }
}
