package org.justinhoang.controller;

import com.google.common.base.Strings;
import org.justinhoang.service.UserInfo;
import org.justinhoang.util.EmailValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Email update controller.
 */
@Controller
public class EmailUpdateController extends AuthenticationBase
{

    /**
     * Email update request model and view.
     *
     * @param model
     *         the model
     * @param request
     *         the request
     *
     * @return the model and view
     */
    @GetMapping("/email-update")
    public ModelAndView emailUpdateRequest(final ModelMap model,
                                           final HttpServletRequest request)
    {
        String   nextView = "email-update";
        UserInfo info     =
                (UserInfo) request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info != null)
        {
            String currentEmail = info.getEmail();
            model.addAttribute("currEmail", currentEmail);
        }
        else
        {
            nextView = "index";
        }
        return new ModelAndView(nextView, model);
    }

    /**
     * Email update request form string.
     *
     * @param newEmail
     *         the new email
     * @param redirect
     *         the redirect
     * @param request
     *         the request
     *
     * @return the string
     */
    @PostMapping("/email-update-form")
    public String EmailUpdateRequestForm(@RequestParam("email")
                                         final String newEmail,
                                         final RedirectAttributes redirect,
                                         final HttpServletRequest request)
    {
        String   nextView = "redirect:email-update";
        UserInfo info     =
                (UserInfo) request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info != null)
        {
            if (Strings.isNullOrEmpty(newEmail))
            {
                redirect.addFlashAttribute("emailError", "Please " +
                                                               "provide an " +
                                                               "email address");
            }
            else if (EmailValidator.isValid(newEmail))
            {
                UserInfo cognitoInfo =
                        authService.getUserInfo(info.getUsername());
                if (!cognitoInfo.getEmail().equals(newEmail))
                {
                    try
                    {
                        authService.updateEmail(info.getUsername(),
                                                newEmail);
                        UserInfo newInfo =
                                authService.getUserInfo(info.getUsername());
                        request.getSession()
                               .setAttribute(USER_SESSION_ATTR, newInfo);
                        nextView = "redirect:setup";
                    }
                    catch (Exception e)
                    {
                        redirect.addFlashAttribute("emailError",
                                                   e.getLocalizedMessage());
                    }
                }
                else
                {
                    redirect.addFlashAttribute("emailError", "The new " +
                                                                   "email " +
                                                                   "address " +
                                                                   "is the " +
                                                                   "same as " +
                                                                   "the " +
                                                                   "address " +
                                                                   "in the " +
                                                                   "database");
                }
            }
            else
            {
                redirect.addFlashAttribute("emailError", "Email format issues" +
                                                         ".");
            }
        }
        else
        {
            nextView = "redirect:/";
        }
        return nextView;
    }

}

