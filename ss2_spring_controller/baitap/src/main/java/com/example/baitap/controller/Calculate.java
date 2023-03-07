package com.example.baitap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class Calculate {
    @GetMapping()
    public String calculate(Model model,
                            @RequestParam(name = "number1", defaultValue = "0") int number1st,
                            @RequestParam(name = "number2", defaultValue = "0") int number2nd,
                            @RequestParam(name = "calculation", defaultValue = "") String cal) {


        int result = 0;
        switch (cal) {
            case "Addition(+)":
                result = number1st + number2nd;
                cal = "Addition";
                break;
            case "Subtraction(-)":
                result = number1st - number2nd;
                cal = "Subtraction";
                break;
            case "Multiplication(X)":
                result = number1st * number2nd;
                cal = "Multiplication";
                break;
            case "Division(/)":
                result = number1st / number2nd;
                cal = "Division";
                break;
        }
        model.addAttribute("number1st", number1st);
        model.addAttribute("number1st", number2nd);
        model.addAttribute("cal", cal);
        model.addAttribute("result", result);
        return "calculate";
    }
}
