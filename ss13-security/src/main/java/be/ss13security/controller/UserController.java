package be.ss13security.controller;

import be.ss13security.entity.UserApp;
import be.ss13security.entity.UserRole;
import be.ss13security.repository.RoleRepository;
import be.ss13security.repository.UserAppRepository;
import be.ss13security.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userApps")
public class UserController {
    @Autowired
    private UserAppRepository userAppRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("userApp", new UserApp());
        return "/userApp/create";
    }

    @PostMapping("/create")
    public String doCreate(Model model, @ModelAttribute("userApp") UserApp userApp) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userApp.setPassword(encoder.encode(userApp.getPassword()));
        userAppRepository.save(userApp);
        return "/userApp/create";
    }

    @GetMapping("/addRole")
    public String showAddRole(Model model) {
        model.addAttribute("userRole", new UserRole());
        model.addAttribute("users", userAppRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "/userApp/addRole";
    }

    @PostMapping("/addRole")
    public String doAddRole(@ModelAttribute("userRole") UserRole userRole) {
        userRoleRepository.save(userRole);
        return "redirect:/userApps/addRole";
    }
}
