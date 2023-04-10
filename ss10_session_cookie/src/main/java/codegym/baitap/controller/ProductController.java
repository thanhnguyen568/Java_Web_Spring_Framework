package codegym.baitap.controller;

import codegym.baitap.entity.Cart;
import codegym.baitap.entity.Product;
import codegym.baitap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/shops")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService service;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/")
    public String showShop(Model model) {
        model.addAttribute("products", service.findAll());
        return "/shop/shop";
    }

    @GetMapping("/add")
    public String addToCart(@ModelAttribute Cart cart,@RequestParam Long id ,@RequestParam String action,Model model){
        Product product = service.findById(id);
        if (product == null) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }
}
