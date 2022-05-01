package org.justinhoang.controller;

import com.google.common.base.Strings;
import org.justinhoang.service.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Account delete controller.
 */
@Controller
public class AccountDeleteController extends AuthenticationBase
{

    /**
     * Delete account string.
     *
     * @param model
     *         the model
     * @param request
     *         the request
     *
     * @return the string
     */
    @GetMapping("/account-delete")
    public String deleteAccount(final Model model,
                                final HttpServletRequest request)
    {
        String nextView = "account-delete";
        UserInfo info =
                (UserInfo) request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info == null)
        {
            nextView = "index";
        }
        return nextView;
    }

    /**
     * Delete account form string.
     *
     * @param password
     *         the password
     * @param redirect
     *         the redirect
     * @param request
     *         the request
     *
     * @return the string
     */
    @PostMapping("/account-delete-form")
    public String deleteAccountForm(@RequestParam("password")
                                    final String password,final
                                    RedirectAttributes redirect,
                                    final HttpServletRequest request)
    {
        String nextView = "redirect:account-delete";
        UserInfo info =
                (UserInfo) request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info != null)
        {
            if (Strings.isNullOrEmpty(password))
            {
                redirect.addFlashAttribute("passwordError",
                                           "Please enter your password");
            }
            else
            {
                try
                {
                    String username = info.getUsername();
                    authService.deleteUser(username, password);

                    request.getSession().setAttribute(USER_SESSION_ATTR, null);
                    nextView = "redirect:/";
                }
                catch (Exception e)
                {
                    redirect.addFlashAttribute("passwordError",
                                               e.getLocalizedMessage());
                }
            }
        }
        else
        {
            nextView = "redirect:/";
        }
        return nextView;
    }

}