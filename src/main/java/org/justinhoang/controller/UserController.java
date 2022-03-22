package org.justinhoang.controller;

import org.justinhoang.entity.User;
import org.justinhoang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private UserService userService;

    @PostMapping("/userCreate")
    public String createUser(@ModelAttribute("user") User entity)
    {
        userService.createUser(entity);
        return "redirect:/user/users-read";
    }

    @GetMapping("/userCreateForm")
    public String userCreateForm(Model entity)
    {
        User user = new User();
        entity.addAttribute("user", user);
        return "user-form";
    }

    @GetMapping("/usersRead")
    public String usersRead(Model entity)
    {
        List<User> users = userService.readUsers();
        entity.addAttribute("users", users);
        return "users-read";
    }

    @GetMapping("/userUpdateForm")
    public String userUpdateForm(@RequestParam("id") Long id, Model entity)
    {
        User user = userService.readUser(id);
        entity.addAttribute("user", user);
        return "user-form";
    }

    @GetMapping("/userDelete")
    public String userDelete(@RequestParam("id") Long id)
    {
        userService.deleteUser(id);
        return "redirect:/user/users-read";
    }
}
