package org.justinhoang.controller;

import org.justinhoang.entity.User;
import org.justinhoang.service.GenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type User controller.
 */
@Controller
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private GenService<User> genService;

    public UserController(GenService<User> genService)
    {
        super();
        this.genService = genService;
    }

    /**
     * Create user string.
     *
     * @param entity
     *         the entity
     *
     * @return the string
     */
    @PostMapping("/userCreate")
    public String userCreate(@ModelAttribute("user") User entity)
    {
        genService.create(entity);
        return "redirect:/user/users-read";
    }

    /**
     * User create form string.
     *
     * @param entity
     *         the entity
     *
     * @return the string
     */
    @GetMapping("/userCreateForm")
    public String userCreateForm(Model entity)
    {
        User user = new User();
        entity.addAttribute("user", user);
        return "user-form";
    }

    /**
     * Users read string.
     *
     * @param entity
     *         the entity
     *
     * @return the string
     */
    @GetMapping("/usersRead")
    public String usersRead(Model entity)
    {
        List<User> users = genService.readAll();
        entity.addAttribute("users", users);
        return "users-read";
    }

    /**
     * User update form string.
     *
     * @param id
     *         the id
     * @param entity
     *         the entity
     *
     * @return the string
     */
    @GetMapping("/userUpdateForm")
    public String userUpdateForm(@RequestParam("id") Long id, Model entity)
    {
        User user = genService.readId(id);
        entity.addAttribute("user", user);
        return "user-form";
    }

    /**
     * User delete string.
     *
     * @param id
     *         the id
     *
     * @return the string
     */
    @GetMapping("/userDelete")
    public String userDelete(@RequestParam("id") Long id)
    {
        genService.delete(id);
        return "redirect:/user/users-read";
    }
}
