package org.justinhoang.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.justinhoang.persistence.UserDao;
import org.justinhoang.entity.User;

import java.util.Date;

@Controller
public class UserSignUpController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView
    userSignUp(@RequestParam("birthdate") Date birthdate,
               @RequestParam("first_name") String firstName,
               @RequestParam("last_name") String lastName,
               @RequestParam("email") String email,
               @RequestParam("phone") String phone,
               @RequestParam("username") String username,
               @RequestParam("password") String password) {

        ModelAndView mv = new ModelAndView();

        User user = new User();
        user.setBirthdate(birthdate);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setUsername(username);

        int counter = userDao.signUpUser(user);

        if (counter > 0) {
            mv.addObject("msg", "User account creation successful.");
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("signup");

        return mv;

    }

}
