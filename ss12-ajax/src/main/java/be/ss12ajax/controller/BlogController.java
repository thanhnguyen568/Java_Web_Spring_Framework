package be.ss12ajax.controller;

import be.ss12ajax.model.Blog;
import be.ss12ajax.service.BlogService;
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
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("blogs",blogService.findAll());
        return "/blog/list";
    }

    @GetMapping("/paging")
    public String listPageSort(@RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size,
//                               @RequestParam("sort") Optional<String> sort,
                               Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(1);
        Sort sort = Sort.by("blogNo").ascending().and(Sort.by("title").descending());

        Page<Blog> blogs = blogService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize, sort));
        model.addAttribute("blogs", blogs);
        return "/blog/listPaging";
    }


}
