package codegym.baitap.controller;

import codegym.baitap.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CartController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public String showCart (@SessionAttribute("cart") Cart cart, Model model){
//        ModelAndView modelAndView = new ModelAndView("/cart");
//        modelAndView.addObject("cart",cart);
        model.addAttribute("cart",cart);
        return "cart";
    }
}
