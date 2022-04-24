package org.justinhoang.controller;

import org.justinhoang.service.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Profile update controller.
 */
@Controller
public class ProfileUpdateController extends AuthenticationBase
{

    /**
     * Profile update model and view.
     *
     * @param model
     *         the model
     * @param redirect
     *         the redirect
     * @param request
     *         the request
     *
     * @return the model and view
     */
    @GetMapping("/profile-update")
    public ModelAndView profileUpdate(ModelMap model,
                                      RedirectAttributes redirect,
                                      HttpServletRequest request)
    {
        String nextView = "profile-update";
        UserInfo info =
                (UserInfo) request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info != null)
        {
            model.addAttribute("userInfo", info);
        }
        else
        {
            nextView = "index";
        }
        return new ModelAndView(nextView, model);
    }

    /**
     * Profile update form string.
     *
     * @param redirect
     *         the redirect
     * @param request
     *         the request
     *
     * @return the string
     */
    @PostMapping("/profile-update-form")
    public String profileUpdateForm(
                                    RedirectAttributes redirect,
                                    HttpServletRequest request)
    {
        String nextView = "redirect:profile-update";
        UserInfo info =
                (UserInfo) request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info != null)
        {
            UserInfo newInfo =
                    new UserInfo(info.getUsername(), info.getEmail());
            authService.updateUserAttributes(newInfo);

            newInfo = authService.getUserInfo(info.getUsername());
            request.getSession().setAttribute(USER_SESSION_ATTR, newInfo);

            nextView = "redirect:setup";

        }
        else
        {

            nextView = "redirect:/";
        }
        return nextView;
    }
}

