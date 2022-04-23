package org.justinhoang.service;

/**
 * The type User info.
 */
public class UserInfo
{
    private final String username;
    private final String email;
    private final String location;

    /**
     * Instantiates a new User info.
     *
     * @param username
     *         the username
     * @param email
     *         the email
     * @param location
     *         the location
     */
    public UserInfo(final String username, final String email,
                    final String location)
    {
        this.username = username;
        this.email    = email;
        this.location = location;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName()
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

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation()
    {
        return location;
    }

}
