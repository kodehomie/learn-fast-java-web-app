package org.justinhoang.controller;

import com.google.common.base.Strings;
import org.justinhoang.service.UserInfo;
import org.justinhoang.util.EmailValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * The type Username read controller.
 */
@Controller
public class UsernameReadController extends AuthenticationBase
{

    /**
     * Username read string.
     *
     * @param model
     *         the model
     *
     * @return the string
     */
    @GetMapping("username-read")
    public String usernameRead(final Model model)
    {
        return "username-read";
    }

    /**
     * Username read form string.
     *
     * @param email
     *         the email
     * @param redirect
     *         the redirect
     *
     * @return the string
     */
    @PostMapping("username-read-form")
    public String usernameReadForm(
            @RequestParam("email") final String email,
            final RedirectAttributes redirect)
    {
        String nextView = "redirect:username-read";
        if (Strings.isNullOrEmpty(email))
        {
            redirect.addFlashAttribute("emailError",
                                       "Please enter your email address");
        }
        else
        {
            if (EmailValidator.isValid(email))
            {
                try
                {
                    UserInfo info = authService.findUserByEmail(email);
                    if (info != null)
                    {
                        String userName = info.getUsername();
                        if (userName != null)
                        {
                            redirect.addFlashAttribute("usernameVal",
                                                       userName);
                            redirect.addFlashAttribute("loginMessage",
                                                       "Your username is " +
                                                       userName);
                            nextView = "redirect:/";
                        }
                        else
                        {
                            redirect.addFlashAttribute("emailError",
                                                       "Unsuccessful and null" +
                                                       " " +
                                                       "username lookup.");
                        }
                    }
                    else
                    {
                        redirect.addFlashAttribute("emailError",
                                                   "Email " + "address " +
                                                   "does not " + "match any " +
                                                   "users.");
                    }
                }
                catch (Exception e)
                {
                    redirect.addFlashAttribute("emailError",
                                               e.getLocalizedMessage());
                }
            }
            else
            {
                redirect.addFlashAttribute("emailError", "Email address " +
                                                          "formatting issue.");
            }
        }
        return nextView;
    }
}
