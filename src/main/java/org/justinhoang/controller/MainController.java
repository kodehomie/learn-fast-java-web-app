package org.justinhoang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController
{
    @RequestMapping("/")
    public String home()
    {
        return "/index";
    }

    @RequestMapping("/welcome")
    public String welcome()
    {
        return "welcome";
    }

//    @GetMapping("/403")
//    public String error403()
//    {
//        return "/error/403";
//    }

}
