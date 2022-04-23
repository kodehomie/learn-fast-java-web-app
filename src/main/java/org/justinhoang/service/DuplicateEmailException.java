package org.justinhoang.service;

import com.amazonaws.services.cognitoidp.model.AWSCognitoIdentityProviderException;

/**
 * The type Duplicate email exception.
 */
public class DuplicateEmailException extends AWSCognitoIdentityProviderException
{

    private static final long serialVersionUID = 6561571810771139916L;

    /**
     * Instantiates a new Duplicate email exception.
     *
     * @param errorMessage
     *         the error message
     */
    public DuplicateEmailException(final String errorMessage)
    {
        super(errorMessage);
    }
}
