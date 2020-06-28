package ru.makk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GETContoroller {

    @GetMapping("/greetings")
    public String greetings(@RequestParam(name = "name", defaultValue = "World", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "greetings";
    }

    @GetMapping
    public String main(Model model){
        model.addAttribute("name", "Data from model");
        return "mainPage";
    }
}
