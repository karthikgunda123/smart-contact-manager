package com.scm.scm2_0.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home Page handler");

        // Sending data to the view
        model.addAttribute("name", "SubString Technologies");
        model.addAttribute("youtubeChannel", "Learn Code with Karthik");
        model.addAttribute("githubRepository", "https://github.com/karthikgunda123/smart-contact-manager");

        return "home";
    }
}
