package erpmini.be.controller;

import erpmini.be.entity.Book;
import erpmini.be.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

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
        Sort sort = Sort.by("bookNo").ascending().and(Sort.by("bookName").descending());

        Page<Book> books = bookService.findWithPage(PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("books", books);
        return "book/listBook";
    }
    }
