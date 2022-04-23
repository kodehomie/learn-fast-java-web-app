package org.justinhoang.service;

/**
 * The type Session info.
 */
public class SessionInfo
{
    final private String session;
    final private String accessToken;
    final private String challengeResult;

    /**
     * Instantiates a new Session info.
     *
     * @param session
     *         the session
     * @param accessToken
     *         the access token
     * @param challengeResult
     *         the challenge result
     */
    public SessionInfo(final String session, final String accessToken,
                       final String challengeResult)
    {
        this.session         = session;
        this.accessToken     = accessToken;
        this.challengeResult = challengeResult;
    }

    /**
     * Gets session.
     *
     * @return the session
     */
    public String getSession()
    {
        return session;
    }

    /**
     * Gets challenge result.
     *
     * @return the challenge result
     */
    public String getChallengeResult()
    {
        return challengeResult;
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public String getAccessToken()
    {
        return accessToken;
    }

}
