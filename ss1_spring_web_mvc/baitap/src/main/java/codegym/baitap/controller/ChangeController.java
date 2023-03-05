package codegym.baitap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChangeController {
    //Load view index
    @GetMapping("/converter")
    public String index() {
        return "converter/changeIndex";
    }

    //Submit and return view change
    @PostMapping("/usd")
    public String submit(@RequestParam String usd, String rate, Model model) {
        float result = Float.parseFloat(usd) * Float.parseFloat(rate);
        model.addAttribute("result", result);
        return "converter/change";
    }
}
