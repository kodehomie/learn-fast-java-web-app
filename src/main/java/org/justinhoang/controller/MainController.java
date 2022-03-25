package org.justinhoang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Main controller.
 */
@Controller
public class MainController
{
    /**
     * Home string.
     *
     * @return the string
     */
    @RequestMapping("/")
    public String home()
    {
        return "index";
    }

    /**
     * Welcome string.
     *
     * @return the string
     */
    @RequestMapping("/welcome")
    public String welcome()
    {
        return "welcome";
    }

}