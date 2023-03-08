package com.example.baitap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class CalculateController {

    @GetMapping()
    public String getCal() {
        return "calculate";
    }


    @PostMapping()
    public String calculate(Model model,
                            @RequestParam(name = "numberOne", defaultValue = "0") int numberOne,
                            @RequestParam(name = "numberTwo", defaultValue = "0") int numberTwo,
                            @RequestParam(name = "calculation", defaultValue = "") String cal) {


        int result = 0;
        switch (cal) {
            case "Addition(+)":
                result = numberOne + numberTwo;
                cal = "Addition";
                break;
            case "Subtraction(-)":
                result = numberOne - numberTwo;
                cal = "Subtraction";
                break;
            case "Multiplication(X)":
                result = numberOne * numberTwo;
                cal = "Multiplication";
                break;
            case "Division(/)":
                result = numberOne / numberTwo;
                cal = "Division";
                break;
        }
        model.addAttribute("number1st", numberOne);
        model.addAttribute("number1st", numberTwo);
        model.addAttribute("cal", cal);
        model.addAttribute("result", result);
        return "calculate";
    }
}
