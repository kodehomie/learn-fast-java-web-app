package org.justinhoang.service;

/**
 * The type Reset password request.
 */
public class ResetPasswordRequest
{
    private final String username;
    private final String resetCode;
    private final String newPassword;

    /**
     * Instantiates a new Reset password request.
     *
     * @param username
     *         the username
     * @param resetCode
     *         the reset code
     * @param newPassword
     *         the new password
     */
    public ResetPasswordRequest(final String username, final String resetCode
            , final String newPassword)
    {
        this.username    = username;
        this.resetCode   = resetCode;
        this.newPassword = newPassword;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Gets reset code.
     *
     * @return the reset code
     */
    public String getResetCode()
    {
        return resetCode;
    }

    /**
     * Gets new password.
     *
     * @return the new password
     */
    public String getNewPassword()
    {
        return newPassword;
    }

}
