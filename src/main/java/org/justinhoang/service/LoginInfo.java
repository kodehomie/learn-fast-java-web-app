package org.justinhoang.service;

/**
 * The type Login info.
 */
public class LoginInfo extends UserInfo
{
    private Boolean newPasswordRequired = false;

    /**
     * Instantiates a new Login info.
     *
     * @param username
     *         the username
     * @param email
     *         the email
     */
    public LoginInfo(final String username, final String email)
    {
        super(username, email);
    }

    /**
     * Instantiates a new Login info.
     *
     * @param userInfo
     *         the user info
     */
    public LoginInfo(final UserInfo userInfo)
    {
        this(userInfo.getUsername(), userInfo.getEmail());
    }

    /**
     * Gets new password required.
     *
     * @return the new password required
     */
    public Boolean getNewPasswordRequired()
    {
        return newPasswordRequired;
    }

    /**
     * Sets new password required.
     *
     * @param newPasswordRequired
     *         the new password required
     */
    public void setNewPasswordRequired(Boolean newPasswordRequired)
    {
        this.newPasswordRequired = newPasswordRequired;
    }

}
