package org.justinhoang.controller;

import org.justinhoang.service.AuthenticationService;

/**
 * The type Authentication base.
 */
public abstract class AuthenticationBase
{
    /**
     * The constant authService.
     */
    protected static       AuthenticationService authService          =
            new AuthenticationService();
    /**
     * The Username min length.
     */
    protected final static int                   USERNAME_MIN_LENGTH = 2;
    /**
     * The Password min length.
     */
    protected final static int                   PASSWORD_MIN_LENGTH  = 8;
    /**
     * The User session attr.
     */
    protected final static String                USER_SESSION_ATTR    =
            "userInfo";
}
