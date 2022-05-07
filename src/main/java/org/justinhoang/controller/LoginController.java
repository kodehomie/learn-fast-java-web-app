package org.justinhoang.controller;

import com.amazonaws.services.cognitoidp.model.NotAuthorizedException;
import com.google.common.base.Strings;
import org.justinhoang.service.LoginInfo;
import org.justinhoang.service.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Login controller.
 */
@Controller
public class LoginController extends AuthenticationBase
{

    /**
     * Login string.
     *
     * @param user
     *         the user
     * @param password
     *         the password
     * @param redirect
     *         the redirect
     * @param request
     *         the request
     *
     * @return the string
     */
    @PostMapping("/login-form")
    public String login(
            @RequestParam("username") String user, @RequestParam("password")
            final String password, final RedirectAttributes redirect,
            final HttpServletRequest request)
    {
        boolean hasErrors   = false;
        String  usernameArg = null;
        String  passwordArg = null;

        String nextView = "redirect:/";
        if (Strings.isNullOrEmpty(user))
        {
            redirect.addFlashAttribute("usernameError",
                                       "Please enter a username");
            hasErrors = true;
        }
        else
        {
            usernameArg = user.trim();
            redirect.addFlashAttribute("usernameVal", usernameArg);
        }
        if (!hasErrors)
        {
            if (Strings.isNullOrEmpty(password))
            {
                redirect.addFlashAttribute("passwordError",
                                           "Please enter your password");
                hasErrors = true;
            }
            else
            {
                passwordArg = password.trim();
            }
        }
        if (!hasErrors)
        {

            try
            {
                LoginInfo loginInfo =
                        authService.userLogin(usernameArg, passwordArg);
                if (loginInfo != null)
                {
                    if (loginInfo.getNewPasswordRequired())
                    {
                        nextView = "redirect:password-update";
                        redirect.addFlashAttribute("usernameVal", usernameArg);
                        redirect.addFlashAttribute("changeType",
                                                   "passwordUpdate");
                    }
                    else
                    {
                        nextView = "redirect:setup";
                        UserInfo userInfo =
                                new UserInfo(loginInfo.getUsername(),
                                             loginInfo.getEmail());

                        request.getSession()
                               .setAttribute(USER_SESSION_ATTR, userInfo);
                    }
                }
            }
            catch (NotAuthorizedException e)
            {
                redirect.addFlashAttribute("loginError",
                                           "Incorrect " + "credentials (alter" +
                                           " username or " + "password.");
            }
            catch (Exception e)
            {
                redirect.addFlashAttribute("loginError", "Login Error: " +
                                                          e.getClass()
                                                           .getName() + " " +
                                                          e.getLocalizedMessage());
            }
        }
        return nextView;
    }
}
