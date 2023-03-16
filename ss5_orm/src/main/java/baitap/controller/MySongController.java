package baitap.controller;

import baitap.entity.MySong;
import baitap.service.MySongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class MySongController {
    @Autowired
    private MySongService service;

    @GetMapping("")
    public String displayList(Model model) {
        List<MySong> mySongList = service.findAll();
        model.addAttribute("mySongList",mySongList);
        return "/song/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("mySong", new MySong());
        return "/song/create";
    }

}
