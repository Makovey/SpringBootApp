package ru.makk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.makk.domain.Message;
import ru.makk.domain.User;
import ru.makk.repositories.MessageRepo;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greetings(@RequestParam(name = "name", defaultValue = "World", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "greetings";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "mainPage";
    }

    @PostMapping
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String text,
                      @RequestParam String tag,
                      Map<String, Object> model) {
        Message message = new Message(text, tag, user); // Аргументы приходят из формы
        messageRepo.save(message); // Сохранение данных
        Iterable<Message> messages = messageRepo.findAll(); // Вывод всех сообщений
        model.put("messages", messages);
        return "mainPage";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if(filter != null && !filter.isEmpty()){
            messages= messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return "mainPage";
    }
}
