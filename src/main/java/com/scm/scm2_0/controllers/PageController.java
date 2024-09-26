package com.scm.scm2_0.controllers;

import com.scm.scm2_0.entities.User;
import com.scm.scm2_0.forms.UserForm;
import com.scm.scm2_0.helpers.Message;
import com.scm.scm2_0.helpers.MessageType;
import com.scm.scm2_0.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home Page handler");

        // Sending data to the view
        model.addAttribute("name", "SubString Technologies");
        model.addAttribute("youtubeChannel", "Learn Code with Karthik");
        model.addAttribute("githubRepository", "https://github.com/karthikgunda123/smart-contact-manager");

        return "home";
    }

    // About Route
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin", false);
        System.out.println("About Page Loading");
        return "about";
    }

    // Services Route
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("Services Page Loading");
        return "services";
    }

    @GetMapping("/contact")
    public String contactPage(){
        return "contact";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        UserForm userForm = new UserForm();
        // userForm.setName("karthik");

        // default data added
        model.addAttribute("userForm", userForm);

        return "register";
    }

    // Processing register
    @PostMapping("/do-register")
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session){
        System.out.println("Processing Registration");

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://isobarscience-1bfd8.kxcdn.com/wp-content/uploads/2020/09/default-profile-picture1.jpg");

        User savedUser = userService.saveUser(user);
        System.out.println("The inserted user is : " + savedUser);

        Message message = Message.builder().content("Registration Successful").type(MessageType.red).build();

        session.setAttribute("message", message);

        return "redirect:/register";
    }

}
