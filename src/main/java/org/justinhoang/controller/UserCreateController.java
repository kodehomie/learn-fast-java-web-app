package org.justinhoang.controller;

import com.google.common.base.Strings;
import org.justinhoang.service.UserInfo;
import org.justinhoang.util.EmailValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * The type User create controller.
 */
@Controller
public class UserCreateController extends AuthenticationBase
{

    /**
     * User create string.
     *
     * @param model
     *         the model
     *
     * @return the string
     */
    @GetMapping("/user-create")
    public String userCreate(final ModelMap model)
    {
        return "/user-create";
    }

    /**
     * New user string.
     *
     * @param userName
     *         the user name
     * @param email
     *         the email
     * @param redirect
     *         the redirect
     *
     * @return the string
     */
    @PostMapping("/user-create-form")
    public String newUser(
            @RequestParam("username") final String userName,
            @RequestParam("email") final String email,
            final RedirectAttributes redirect)
    {
        String  newPage     = "redirect:user-create";
        String  userNameArg = null;
        String  emailArg    = null;
        boolean badArgument = false;
 
        if (Strings.isNullOrEmpty(userName))
        {
            redirect.addFlashAttribute("userNameError",
                                       "A username is required");
            badArgument = true;
        }
        else
        {
            userNameArg = userName.trim();
            if (userNameArg.length() >= USERNAME_MIN_LENGTH)
            {
                try
                {
                    if (!authService.hasUser(userNameArg))
                    {
                        redirect.addFlashAttribute("userNameVal", userNameArg);
                    }
                    else
                    {
                        redirect.addFlashAttribute("userNameError",
                                                   "The user name \"" +
                                                   userNameArg +
                                                   "\" is already in use.");
                        badArgument = true;
                    }
                }
                catch (Exception e)
                {
                    redirect.addFlashAttribute("userNameError",
                                               "Error looking up user name: " +
                                               e.getLocalizedMessage());
                }
            }
            else
            {
                redirect.addFlashAttribute("userNameError",
                                           "User names must be at least " +
                                           USERNAME_MIN_LENGTH +
                                           " characters");
                badArgument = true;
            }
        }
        if (!badArgument)
        {
            if (Strings.isNullOrEmpty(email))
            {
                redirect.addFlashAttribute("emailError",
                                           "Please provide an email address");
                badArgument = true;
            }
            else
            {
                emailArg = email.trim();
                if (EmailValidator.isValid(emailArg))
                {

                    UserInfo info = authService.findUserByEmail(emailArg);
                    if (info != null)
                    { // there is a user with that email address
                        redirect.addFlashAttribute("emailError",
                                                   "That email address is " +
                                                   "already in use");
                        badArgument = true;
                    }
                }
                else
                {
                    redirect.addFlashAttribute("emailError",
                                               "Email address is not properly" +
                                               " formed");
                    badArgument = true;
                }
            }
        }

        if (!badArgument)
        {
            try
            {
                UserInfo userInfo =
                        new UserInfo(userNameArg, emailArg);
                authService.createNewUser(userInfo);
                redirect.addFlashAttribute("loginMessage",
                                           "Your username is " + userNameArg +
                                           ". Please check your email for " +
                                           "your temporary password");
                redirect.addFlashAttribute("username_val", userNameArg);
                newPage = "redirect:/";
            }
            catch (Exception e)
            {
                redirect.addFlashAttribute("createUserError",
                                           "Error creating new user: " +
                                           e.getLocalizedMessage());
            }
        }
        return newPage;
    }
}

