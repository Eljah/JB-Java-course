package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/")
    public String showIndexPage() {
        return "index";
    }

}
