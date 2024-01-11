package com.mansar.chatroom.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/", "/index", "/dashboard"})
public class HomeController {

    @GetMapping("")
    public String getIndexPage() {
        return "home";
    }
}
