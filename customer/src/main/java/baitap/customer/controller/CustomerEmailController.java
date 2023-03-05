package baitap.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class CustomerEmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    @Autowired
    private static Pattern pattern;
    private Matcher matcher;

    public CustomerEmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    @GetMapping("email/")
    String getFormEmail() {
        return "email/email";
    }

    @PostMapping("email/validate")
    String validateEmail(@RequestParam("email") String email, Model model) {
        boolean isValid = this.validate(email);
        if (!isValid) {
            model.addAttribute("message", "Email is invalid");
            return "email/email";
        }

        model.addAttribute("message", email + " is valid");
        return "email/email";
    }

}
