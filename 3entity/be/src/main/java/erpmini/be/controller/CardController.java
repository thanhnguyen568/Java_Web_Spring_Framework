package erpmini.be.controller;

import erpmini.be.entity.Book;
import erpmini.be.entity.Card;
import erpmini.be.service.BookService;
import erpmini.be.service.CardService;
import erpmini.be.service.StudentService;
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
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CardService cardService;

    /**
     * Search & Paging
     */
    @GetMapping("")
    public String searchPageSort(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size,
                                 Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Sort sort = Sort.by("cardCode").ascending().and(Sort.by("status").ascending());

        Page<Card> cards = cardService.findWithHQL(PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("cards", cards);
        return "/card/listCard";
    }

    /**
     * Create
     */
    @GetMapping("/create")
    public String showFormCreate(@RequestParam Long bookNo, Model model) {
        model.addAttribute("card", new Card());

        // Entity 2nd
        Book book = bookService.findByNo(bookNo);
        model.addAttribute("book", book);

        // Entity 3rd
        model.addAttribute("students", studentService.findAll());
        return "/card/create";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("card") Card card, BindingResult bindingResult, Model model
            , RedirectAttributes redirect) {
        // Decreased Quantity Entity 2nd
        // Book book = card.getBook();
        Book book = bookService.findByNo(card.getBook().getBookNo());
        Long newQuantity = book.getBookQuantity() - 1;
        book.setBookQuantity(newQuantity);

        // Save new Book Card
        cardService.save(card);
        redirect.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/books";
    }

    /**
     * Update
     */
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam Long cardNo, Model model) {
        // Find Entity 1st
        model.addAttribute("card", cardService.findByNo(cardNo));

        // Find Entity 2nd
        model.addAttribute("students", studentService.findAll());
        return "/card/update";
    }

    @PostMapping("/update")
    public String doUpdate(Card card, RedirectAttributes redirect) {
        // Decreased Quantity Entity 2nd
        Book book = card.getBook();
        Long newQuantity = book.getBookQuantity()+1;
        book.setBookQuantity(newQuantity);

        // Update Entity 1st by ID
        cardService.update(card.getCardNo());
        redirect.addFlashAttribute("message", "update successfully!");
        return "redirect:/books";
    }

    @GetMapping("/delete/{cardNo}")
    public String doDeleteOne(@PathVariable Long cardNo) {
        // Decreased Quantity Entity 2nd
        Book book = cardService.findByNo(cardNo).getBook();
        Long newQuantity = book.getBookQuantity()+1;
        book.setBookQuantity(newQuantity);

        cardService.update(cardNo);
        return "redirect:/cards";
    }
}
