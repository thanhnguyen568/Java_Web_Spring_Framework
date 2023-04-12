package be.demo.controller;

import be.demo.entity.HomeStay;
import be.demo.entity.Payment;
import be.demo.service.HomeStayService;
import be.demo.service.PaymentService;
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
@RequestMapping("homeStays")
public class HomeStayController {
    @Autowired
    HomeStayService homeStayService;
    @Autowired
    PaymentService paymentService;
    @GetMapping("")
    public String listPageSort(@RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size,
//                               @RequestParam("sort") Optional<String> sort,
                               Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Sort sort = Sort.by("no").ascending().and(Sort.by("name").descending());

        Page<HomeStay> homeStays = homeStayService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("homeStays", homeStays);
        return "/home/listPaging";
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
        Sort sort = Sort.by("no").ascending().and(Sort.by("name").ascending());

        model.addAttribute("search", input);
        Page<HomeStay> homeStays = homeStayService.searchAllWithPage(input, input, PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("homeStays", homeStays);
        return "/home/listPaging";
    }
    /**
     * Create
     */
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("homeStay", new HomeStay());

        // Entity 2nd
        model.addAttribute("payments", paymentService.findAll());
        return "/home/create";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("homeStay") HomeStay honeStay, BindingResult bindingResult, Model model
            , RedirectAttributes redirect) {
//        customerValidate.validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            // Entity 2nd
            model.addAttribute("payments", paymentService.findAll());
            if (honeStay.getPayment() == null) {
                honeStay.setPayment(new Payment());
            }
            return "/home/create";
        }
        homeStayService.save(honeStay);
        redirect.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/homeStays";
    }
    /**
     * Delete
     */
    @PostMapping("/delete")
    public String doDelete(@RequestParam("checkbox") long[] checkbox, Model model, RedirectAttributes redirect) {
        for (long no : checkbox) {
            homeStayService.remove(no);
            redirect.addFlashAttribute("message", "Removed successfully!");
        }
        return "redirect:/homeStays";
    }
}
