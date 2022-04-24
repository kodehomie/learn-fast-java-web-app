package org.justinhoang.service;

/**
 * The type User info.
 */
public class UserInfo
{
    private final String username;
    private final String email;

    /**
     * Instantiates a new User info.
     *
     * @param username
     *         the username
     * @param email
     *         the email
     */
    public UserInfo(final String username, final String email)
    {
        this.username = username;
        this.email    = email;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }


}
