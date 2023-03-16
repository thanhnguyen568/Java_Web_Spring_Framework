package baitap.controller;

import baitap.entity.MySong;
import baitap.service.MySongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/created")
    public String created(@ModelAttribute MySong mySong, Model model, RedirectAttributes redirect) {
        service.create(mySong);
        redirect.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/songs";
    }

    @GetMapping("/{songNo}/update")
    public String showFormUpdate(@PathVariable String songNo, Model model) {
        model.addAttribute("mySong", service.findByNo(songNo));
        return "/song/update";
    }

    @PostMapping("/updated")
    public String update(MySong mySong, RedirectAttributes redirect) {
        service.update(mySong);
        redirect.addFlashAttribute("message", "update successfully!");
        return "redirect:/songs";
    }

    @GetMapping("/{songNo}/delete")
    public String delete(MySong mySong, RedirectAttributes redirect) {
        service.delete(mySong);
        redirect.addFlashAttribute("message", "Removed successfully!");
        return "redirect:/songs";
    }
}
