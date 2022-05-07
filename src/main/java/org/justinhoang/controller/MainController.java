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
public class MainController extends AuthenticationBase
{
    /**
     * Home string.
     *
     * @return the string
     */
    @RequestMapping("/")
    public ModelAndView index(final ModelMap model,
                              final HttpServletRequest request ) {
        String nextView = "index";
        UserInfo info = (UserInfo)request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info != null) {

            nextView = "setup";
            model.addAttribute(USER_SESSION_ATTR, info);
        }
        return new ModelAndView(nextView, model);
    }

    @RequestMapping("/setup")
    public ModelAndView setup(final ModelMap model,
                              final HttpServletRequest request ) {
        String nextView = "index";
        UserInfo info = (UserInfo)request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info != null) {

            nextView = "setup";
            model.addAttribute(USER_SESSION_ATTR, info);
        }
        return new ModelAndView(nextView, model);
    }

    @RequestMapping("/scratch")
    public ModelAndView scratch(final ModelMap model,
                                final HttpServletRequest request ) {
        String nextView = "scratch";
        UserInfo info = (UserInfo)request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info != null) {

            nextView = "scratch";
            model.addAttribute(USER_SESSION_ATTR, info);
        }
        return new ModelAndView(nextView, model);
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