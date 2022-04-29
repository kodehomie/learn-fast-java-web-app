package org.justinhoang.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Email validator.
 */
public class EmailValidator
{
    private static final String  EMAIL_PATTERN =
            "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*" +
            "(.[A-Za-z]{2,})$";
    private static final Pattern pattern       = Pattern.compile(EMAIL_PATTERN);

    /**
     * Is valid boolean.
     *
     * @param email
     *         the email
     *
     * @return the boolean
     */
    public static boolean isValid(String email)
    {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}