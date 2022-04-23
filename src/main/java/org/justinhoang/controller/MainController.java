package org.justinhoang.controller;

import javax.servlet.http.HttpServletRequest;

import org.justinhoang.service.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
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