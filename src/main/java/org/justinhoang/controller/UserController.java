package org.justinhoang.controller;

import org.justinhoang.entity.User;
import org.justinhoang.persistence.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController
{

    private final UserRepo userRepo;

    public UserController(final UserRepo userRepo)
    {
        this.userRepo = userRepo;
    }

    @GetMapping("/userCreateForm")
    public ModelAndView userCreateForm()
    {
        ModelAndView mav  = new ModelAndView("user-create-form");
        User         user = new User();
        mav.addObject("user", user);
        return mav;
    }

    @GetMapping({"/usersRead"})
    public ModelAndView getAllUsers()
    {
        ModelAndView mav = new ModelAndView("users-read");
        mav.addObject("users", userRepo.findAll());
        return mav;
    }

    @PostMapping("/userUpdate")
    public String saveUser(@ModelAttribute User user)
    {
        userRepo.save(user);
        return "redirect:/list";
    }

    @GetMapping("/userUpdateForm")
    public ModelAndView userUpdateForm(@RequestParam Long userId)
    {
        ModelAndView mav  = new ModelAndView("user-create-form");
        User         user = userRepo.findById(userId).get();
        mav.addObject("user", user);
        return mav;
    }

    @GetMapping("/userDelete")
    public String deleteUser(@RequestParam Long id)
    {
        userRepo.deleteById(id);
        return "redirect:/list";
    }
}
