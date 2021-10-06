package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.User;
import com.svat.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public String getUsers(){
        return "User";
    }

    public RedirectView addView(User user, RedirectAttributes redir){
        userService.save(user);
        RedirectView redirectView = new RedirectView("/login", true);
        redir.addFlashAttribute("message", "You succsessfully register! You can now login");

        return redirectView;
    }
}
