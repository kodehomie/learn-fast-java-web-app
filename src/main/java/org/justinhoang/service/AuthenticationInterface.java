package org.justinhoang.service;

/**
 * The interface Authentication interface.
 */
public interface AuthenticationInterface
{

    /**
     * Create new user.
     *
     * @param userInfo
     *         the user info
     *
     * @throws Exception
     *         the exception
     */
    void createNewUser(UserInfo userInfo) throws Exception;

    /**
     * Delete user.
     *
     * @param username
     *         the username
     * @param password
     *         the password
     *
     * @throws Exception
     *         the exception
     */
    void deleteUser(String username, String password) throws Exception;

    /**
     * Find user by email user info.
     *
     * @param email
     *         the email
     *
     * @return the user info
     *
     * @throws Exception
     *         the exception
     */
    UserInfo findUserByEmail(final String email) throws Exception;

    /**
     * Update user attributes.
     *
     * @param newInfo
     *         the new info
     *
     * @throws Exception
     *         the exception
     */
    void updateUserAttributes(UserInfo newInfo) throws Exception;

    /**
     * User login login info.
     *
     * @param username
     *         the username
     * @param password
     *         the password
     *
     * @return the login info
     *
     * @throws Exception
     *         the exception
     */
    LoginInfo userLogin(String username, String password) throws Exception;

    /**
     * User logout.
     *
     * @param username
     *         the username
     *
     * @throws Exception
     *         the exception
     */
    void userLogout(String username) throws Exception;

    /**
     * Change from temporary password.
     *
     * @param passwordRequest
     *         the password request
     *
     * @throws Exception
     *         the exception
     */
    public void changeFromTemporaryPassword(final PasswordRequest passwordRequest) throws
                                                                                   Exception;

    /**
     * Forgot password.
     *
     * @param username
     *         the username
     *
     * @throws Exception
     *         the exception
     */
    void forgotPassword(final String username) throws Exception;

    /**
     * Gets user info.
     *
     * @param username
     *         the username
     *
     * @return the user info
     *
     * @throws Exception
     *         the exception
     */
    UserInfo getUserInfo(String username) throws Exception; // getUserInfo

    /**
     * Has user boolean.
     *
     * @param username
     *         the username
     *
     * @return the boolean
     */
    boolean hasUser(String username);

    /**
     * Reset password.
     *
     * @param resetRequest
     *         the reset request
     *
     * @throws Exception
     *         the exception
     */
    void resetPassword(ResetPasswordRequest resetRequest) throws Exception;

    /**
     * Change password.
     *
     * @param passwordRequest
     *         the password request
     *
     * @throws Exception
     *         the exception
     */
    void changePassword(PasswordRequest passwordRequest) throws Exception;

    /**
     * Change email.
     *
     * @param username
     *         the username
     * @param newEmail
     *         the new email
     *
     * @throws Exception
     *         the exception
     */
    void changeEmail(String username, String newEmail) throws Exception;
}
