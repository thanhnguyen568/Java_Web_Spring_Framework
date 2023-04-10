package codegym.baitap.controller;

import codegym.baitap.entity.Cart;
import codegym.baitap.entity.Product;
import codegym.baitap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
//@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService service;
//
//    @ModelAttribute("cart")
//    public Cart setupCart() {
//        return new Cart();
//    }

    @GetMapping("/shop")
    public String showShop(Model model, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null) {
            session.setAttribute("cart", new Cart());
        }
        model.addAttribute("products", service.findAll());
        return "/shop/product";
    }

    @GetMapping("/shop/add")
    public String addToCart(@RequestParam("id") Long id, Model model,HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        Product product = service.findById(id);
        if (product == null) {
            return "/shop/cart";
        }
//        if (action.equals("show")) {
//            cart.addProduct(product);
//            return "redirect:/shopping-cart";
//        }
        cart.addProduct(product);
        session.setAttribute("cart",cart);
        return "redirect:/shop";
    }
}
