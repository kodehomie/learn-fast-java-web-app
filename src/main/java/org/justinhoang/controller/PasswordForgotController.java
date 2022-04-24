package org.justinhoang.controller;

import com.amazonaws.services.cognitoidp.model.InvalidParameterException;
import com.amazonaws.services.cognitoidp.model.UserNotFoundException;
import com.google.common.base.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Password forgot controller.
 */
@Controller
public class PasswordForgotController extends AuthenticationBase
{

    /**
     * Password forgot view string.
     *
     * @param model
     *         the model
     *
     * @return the string
     */
    @GetMapping("/password-forgot")
    public String passwordForgotView(Model model)
    {
        return "password-forgot";
    }

    /**
     * Password forgot form string.
     *
     * @param user
     *         the user
     * @param redirect
     *         the redirect
     * @param request
     *         the request
     *
     * @return the string
     */
    @PostMapping("/password-forgot-form")
    public String passwordForgotForm(@RequestParam("username")
                                            String user,
                                    RedirectAttributes redirect,
                                    HttpServletRequest request)
    {
        boolean hasErrors   = false;
        String  usernameArg = null;
        String  nextView    = "redirect:forgot-password";
        if (Strings.isNullOrEmpty(user))
        {
            redirect.addFlashAttribute("usernameError",
                                       "Please enter a username");
            hasErrors = true;
        }
        else
        {
            usernameArg = user.trim();
        }
        if (!hasErrors)
        {
            try
            {
                authService.forgotPassword(usernameArg);
                redirect.addFlashAttribute("message", "A reset code was sent " +
                                                      "to your email address");
                redirect.addFlashAttribute("usernameVal", usernameArg);
                redirect.addFlashAttribute("changeType", "targetPassword");

                request.getSession()
                       .setAttribute(super.USER_SESSION_ATTR, null);
                nextView =
                        "redirect:password-update"; // Go to the form to reset
                // the password.
            }
            catch (UserNotFoundException e)
            {
                redirect.addFlashAttribute("usernameError",
                                           "No user found. " + usernameArg);
            }
            catch (InvalidParameterException e)
            {
                redirect.addFlashAttribute("usernameError",
                                           "No email or " + "phone found.");
            }
            catch (Exception e)
            {
                redirect.addFlashAttribute("usernameError",
                                           "Username error: " +
                                           e.getClass().getName() + " " +
                                           e.getLocalizedMessage());
            }
        }
        return nextView;
    }
}
