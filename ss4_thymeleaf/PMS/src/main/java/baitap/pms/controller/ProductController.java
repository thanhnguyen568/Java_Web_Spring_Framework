package baitap.pms.controller;

import baitap.pms.model.Product;
import baitap.pms.repository.impl.ProductRepositoryImpl;
import baitap.pms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String display(Model model) {
        model.addAttribute("products", service.findAll());
        System.out.println("ok");
        for (Product product : service.findAll())
            System.err.println(product);
        return "/product/list";
    }
}
