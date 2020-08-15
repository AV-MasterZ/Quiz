package org.zhadaev.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String login() {
        return "redirect:/login";
    }

}
