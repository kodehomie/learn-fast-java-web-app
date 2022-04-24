package org.justinhoang.controller;

import com.amazonaws.services.cognitoidp.model.InvalidPasswordException;
import com.google.common.base.Strings;
import org.justinhoang.service.ResetPasswordRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * The type Password update controller.
 */
@Controller
public class PasswordUpdateController extends AuthenticationBase
{

    /**
     * Password update string.
     *
     * @param model
     *         the model
     *
     * @return the string
     */
    @GetMapping("password-update")
    public String passwordUpdate(Model model)
    {
        return "password-update";
    }

    /**
     * Password update form string.
     *
     * @param username
     *         the username
     * @param resetCode
     *         the reset code
     * @param newPassword
     *         the new password
     * @param verifyPassword
     *         the verify password
     * @param redirect
     *         the redirect
     *
     * @return the string
     */
    @PostMapping("password-update-form")
    public String passwordUpdateForm(
            @RequestParam("username") final String username,
            @RequestParam("resetCode") final String resetCode,
            @RequestParam("newPassword") final String newPassword,
            @RequestParam("verifyPassword")
            final String verifyPassword, RedirectAttributes redirect)
    {
        boolean hasErrors         = false;
        String  usernameArg       = null;
        String  resetCodeArg      = null;
        String  newPasswordArg    = null;
        String  verifyPasswordArg = null;

        String nextView = "redirect:password-update";
        if (Strings.isNullOrEmpty(username))
        {
            redirect.addFlashAttribute("usernameError",
                                       "Please enter a username");
            hasErrors = true;
        }
        else
        {
            usernameArg = username.trim();
            redirect.addFlashAttribute("usernameVal", usernameArg);
        }
        if (!hasErrors)
        {
            if (Strings.isNullOrEmpty(resetCode))
            {
                redirect.addFlashAttribute("resetCodeError",
                                           "Please enter the reset code");
                hasErrors = true;
            }
            else
            {
                resetCodeArg = resetCode.trim();
            }
        }
        if (!hasErrors)
        {
            if (Strings.isNullOrEmpty(newPassword))
            {
                redirect.addFlashAttribute("newPasswordError",
                                           "Please enter a new password");
                hasErrors = true;
            }
            else
            {
                newPasswordArg = newPassword.trim();
                if (newPasswordArg.length() < PASSWORD_MIN_LENGTH)
                {
                    redirect.addFlashAttribute("newPasswordError",
                                               "New password length " +
                                               "requirement: " + " " +
                                               PASSWORD_MIN_LENGTH +
                                               " characters long");
                    hasErrors = true;
                }
            }
        }
        if (!hasErrors)
        {
            if (Strings.isNullOrEmpty(verifyPassword))
            {
                redirect.addFlashAttribute("verifyPasswordError",
                                           "Please enter your new password " +
                                           "again");
                hasErrors = true;
            }
            else
            {
                verifyPasswordArg = verifyPassword.trim();
                if (!newPasswordArg.equals(verifyPasswordArg))
                {
                    redirect.addFlashAttribute("verifyPasswordError",
                                               "Passwords mismatch");
                    hasErrors = true;
                }
            }
        }

        if (!hasErrors)
        {
            try
            {
                ResetPasswordRequest resetRequest =
                        new ResetPasswordRequest(usernameArg, resetCodeArg,
                                                 newPasswordArg);
                authService.resetPassword(resetRequest);
                redirect.addFlashAttribute("usernameVal", username);
                nextView = "redirect:/";
            }
            catch (InvalidPasswordException e)
            {
                redirect.addFlashAttribute("passwordUpdateError",
                                           "Invalid Password Error: " +
                                           e.getErrorMessage());
            }
            catch (Exception e)
            {
                redirect.addFlashAttribute("passwordUpdateError",
                                           "Password Reset Error: " +
                                           e.getLocalizedMessage());
            }
        }
        return nextView;
    }
}

