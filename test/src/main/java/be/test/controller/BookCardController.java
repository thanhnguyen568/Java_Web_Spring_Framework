package be.test.controller;

import be.test.entity.Book;
import be.test.entity.BookCard;
import be.test.service.BookCardService;
import be.test.service.BookService;
import be.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/bookCards")
public class BookCardController {
    @Autowired
    private BookCardService bookCardService;
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;

    /**
     * Paging & Sorting
     */
    @GetMapping("")
    public String listPageSort(@RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size,
//                               @RequestParam("sort") Optional<String> sort,
                               Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Sort sort = Sort.by("bookCardNo").ascending();

        Page<BookCard> bookCards = bookCardService.findAll(PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("bookCards", bookCards);
        return "/bookCard/listPaging";
    }

    /**
     * Create
     */
    @GetMapping("/create")
    public String showFormCreate(@RequestParam Long bookNo, Model model) {
        model.addAttribute("bookCard", new BookCard());
        // Entity 2nd
        model.addAttribute("book", bookService.findByNo(bookNo));
        model.addAttribute("students", studentService.listAll());
        return "/bookCard/create";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("bookCard") BookCard bookCard, BindingResult bindingResult, Model model
            , RedirectAttributes redirect) {
//        customerValidate.validate(customer, bindingResult);
//        if (bindingResult.hasErrors()) {
//            // Entity 2nd
//            model.addAttribute("types", typeService.findAll());
//            if (customer.getTypeCustomer() == null) {
//                customer.setTypeCustomer(new TypeCustomer());
//            }
//            return "/customer/create";
//        }

        bookCardService.save(bookCard);
//        bookService.changeQuantity(bookCard.getBook().getBookQuantity()-1);
        redirect.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/books";
    }
}
