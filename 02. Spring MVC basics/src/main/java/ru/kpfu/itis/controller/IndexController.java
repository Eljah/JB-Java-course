package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    SessionHistory sessionHistory;

    @RequestMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @RequestMapping("/test")
    public String showAnotherPage(@RequestParam("result") String result, Model model) {
        model.addAttribute("text", "Какой-то текст");
        model.addAttribute("result", result);
        return "another";
    }

    @RequestMapping("/test/{username}")
    public String showUsername(@PathVariable("username") String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("history", sessionHistory.getUsernames());
        sessionHistory.getUsernames().add(username);
        return "usernameshow";
    }
}
