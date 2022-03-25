package org.justinhoang.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Cognito token header.
 */
public class CognitoTokenHeader
{

    @JsonProperty("kid")
    private String kid;

    @JsonProperty("alg")
    private String alg;

    /**
     * Gets kid.
     *
     * @return the kid
     */
    public String getKid()
    {
        return kid;
    }

    /**
     * Gets alg.
     *
     * @return the alg
     */
    public String getAlg()
    {
        return alg;
    }
}
