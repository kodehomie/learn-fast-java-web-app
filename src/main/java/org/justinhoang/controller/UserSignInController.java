package org.justinhoang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.justinhoang.persistence.UserDao;
import org.justinhoang.entity.User;

@Controller
public class UserSignInController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView userSignIn(@RequestParam("username") String username, @RequestParam("password") String password) {

        ModelAndView mv = new ModelAndView();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        String name = userDao.signInUser(user);

        if (name != null) {

            mv.addObject("msg", "Welcome " + name + ", You have successfully logged in.");
            mv.setViewName("welcome");

        } else {

            mv.addObject("msg", "Invalid user id or password.");
            mv.setViewName("signin");
        }

        return mv;

    }

}
