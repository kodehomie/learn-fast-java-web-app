package org.justinhoang.controller;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.User;
import org.justinhoang.service.UserService;
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
    private       UserService userService;
    private final Logger      logger = LogManager.getLogger(this.getClass());

    /**
     * User create string.
     *
     * @param user
     *         the user
     *
     * @return the string
     */
    @PostMapping("/userCreate")
    public String userCreate(@ModelAttribute("user") User user)
    {
        userService.createUser(user);
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
        List<User> users = userService.readUsers();
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
    @SneakyThrows
    @GetMapping("/userUpdateForm")
    public String userUpdateForm(@RequestParam("id") Long id, Model entity)

    {
        User user = userService.readUser(id);
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
    @SneakyThrows
    @GetMapping("/userDelete")
    public String userDelete(@RequestParam("id") Long id)
    {
        userService.deleteUser(id);
        return "redirect:/user/users-read";
    }
}
