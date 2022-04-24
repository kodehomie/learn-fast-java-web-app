package org.justinhoang.service;

/**
 * The type Password request.
 */
public class PasswordRequest {
    private final String userName;
    private final String oldPassword;
    private final String newPassword;

    /**
     * Instantiates a new Password request.
     *
     * @param userName
     *         the user name
     * @param oldPassword
     *         the old password
     * @param newPassword
     *         the new password
     */
    public PasswordRequest(final String userName, final String oldPassword, final String newPassword) {
        this.userName = userName;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUsername() {
        return userName;
    }

    /**
     * Gets old password.
     *
     * @return the old password
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Gets new password.
     *
     * @return the new password
     */
    public String getNewPassword() {
        return newPassword;
    }

}
