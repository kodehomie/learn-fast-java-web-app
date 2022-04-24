package org.justinhoang.service;

import com.amazonaws.SdkBaseException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Authentication service.
 */
public class AuthenticationService
        implements AuthenticationInterface, CognitoResources
{
    private String USERNAME     = "USERNAME";
    private String PASSWORD     = "PASSWORD";
    private String NEW_PASSWORD = "NEW_PASSWORD";

    /**
     * The M identity provider.
     */
    protected AWSCognitoIdentityProvider mIdentityProvider = null;

    /**
     * Instantiates a new Authentication service.
     */
    public AuthenticationService()
    {
        if (mIdentityProvider == null)
        {
            mIdentityProvider = getAmazonCognitoIdentityClient();
        }
    }

    /**
     * Gets credentials.
     *
     * @param AWS_ID
     *         the aws id
     * @param AWS_KEY
     *         the aws key
     *
     * @return the credentials
     */
    protected AWSCredentials getCredentials(String AWS_ID, String AWS_KEY)
    {
        AWSCredentials credentials = new BasicAWSCredentials(AWS_ID, AWS_KEY);
        return credentials;
    }

    /**
     * Gets amazon cognito identity client.
     *
     * @return the amazon cognito identity client
     */
    protected AWSCognitoIdentityProvider getAmazonCognitoIdentityClient()
    {
        AWSCredentials credentials = getCredentials(cognitoId, cognitoKey);
        AWSCredentialsProvider credProvider =
                new AWSStaticCredentialsProvider(credentials);
        AWSCognitoIdentityProvider client =
                AWSCognitoIdentityProviderClientBuilder.standard()
                                                       .withCredentials(
                                                               credProvider)
                                                       .withRegion(region)
                                                       .build();
        return client;
    }

    @Override
    public void createNewUser(final UserInfo userInfo) throws
                                                       AWSCognitoIdentityProviderException
    {
        final String email = userInfo.getEmail();
        if (email != null && email.length() > 0)
        {

            UserInfo data = findUserByEmail(email);
            if (data == null)
            {
                AdminCreateUserRequest cognitoRequest =
                        new AdminCreateUserRequest().withUserPoolId(poolId)
                                                    .withUsername(
                                                            userInfo.getUsername())
                                                    .withUserAttributes(
                                                            new AttributeType().withName(
                                                                                       email)
                                                                               .withValue(
                                                                                       email),
                                                            new AttributeType().withName(
                                                                                       "emailVerified")
                                                                               .withValue(
                                                                                       "true"));

                mIdentityProvider.adminCreateUser(cognitoRequest);
            }
            else
            {

                throw new DuplicateEmailException(
                        "The email address " + email + " already exists.");
            }
        }
    }

    @Override
    public void deleteUser(final String username, final String password) throws
                                                                         AWSCognitoIdentityProviderException
    {
        SessionInfo sessionInfo = sessionLogin(username, password);
        if (sessionInfo != null)
        {
            AdminDeleteUserRequest deleteRequest =
                    new AdminDeleteUserRequest().withUsername(username)
                                                .withUserPoolId(poolId);
            mIdentityProvider.adminDeleteUser(deleteRequest);
        }
    }

    @Override
    public void updateUserAttributes(final UserInfo newData) throws
                                                             AWSCognitoIdentityProviderException
    {
        AdminUpdateUserAttributesRequest updateRequest =
                new AdminUpdateUserAttributesRequest().withUsername(
                                                              newData.getUsername()).withUserPoolId(poolId)
                                                      .withUserAttributes();
        mIdentityProvider.adminUpdateUserAttributes(updateRequest);
    }

    /**
     * Session login session info.
     *
     * @param username
     *         the username
     * @param password
     *         the password
     *
     * @return the session info
     *
     * @throws AWSCognitoIdentityProviderException
     *         the aws cognito identity provider exception
     */
    protected SessionInfo sessionLogin(final String username,
                                       final String password) throws
                                                                                     AWSCognitoIdentityProviderException
    {
        SessionInfo             data       = null;
        HashMap<String, String> authParams = new HashMap<String, String>();
        authParams.put("USERNAME", username);
        authParams.put("PASSWORD", password);
        AdminInitiateAuthRequest authRequest =
                new AdminInitiateAuthRequest().withAuthFlow(
                                                      AuthFlowType.ADMIN_NO_SRP_AUTH).withUserPoolId(poolId)
                                              .withClientId(clientId)
                                              .withAuthParameters(authParams);
        AdminInitiateAuthResult authResult =
                mIdentityProvider.adminInitiateAuth(authRequest);
        if (authResult != null)
        {
            final String session     = authResult.getSession();
            String       accessToken = null;
            AuthenticationResultType resultType =
                    authResult.getAuthenticationResult();
            if (resultType != null)
            {
                accessToken = resultType.getAccessToken();
            }
            final String challengeResult = authResult.getChallengeName();
            data = new SessionInfo(session, accessToken, challengeResult);
        }
        return data;
    }

    @Override
    public LoginInfo userLogin(final String username, final String password) throws
                                                                             AWSCognitoIdentityProviderException
    {
        LoginInfo   loginInfo   = null;
        SessionInfo sessionInfo = sessionLogin(username, password);

        if (sessionInfo != null)
        {
            UserInfo userInfo = getUserInfo(username);
            loginInfo = new LoginInfo(userInfo);

            String challengeResult = sessionInfo.getChallengeResult();
            if (challengeResult != null && challengeResult.length() > 0)
            {
                loginInfo.setNewPasswordRequired(challengeResult.equals(
                        ChallengeNameType.NEW_PASSWORD_REQUIRED.name()));
            }
        }
        return loginInfo;
    }

    @Override
    public void userLogout(final String username) throws
                                                  AWSCognitoIdentityProviderException
    {
        AdminUserGlobalSignOutRequest signOutRequest =
                new AdminUserGlobalSignOutRequest().withUsername(username)
                                                   .withUserPoolId(poolId);

        mIdentityProvider.adminUserGlobalSignOut(signOutRequest);
    }

    @Override
    public void updatePassword(final PasswordRequest passwordRequest) throws
                                                                      AWSCognitoIdentityProviderException
    {

        final SessionInfo sessionInfo =
                sessionLogin(passwordRequest.getUsername(),
                             passwordRequest.getOldPassword());
        if (sessionInfo != null && sessionInfo.getAccessToken() != null)
        {
            ChangePasswordRequest changeRequest =
                    new ChangePasswordRequest().withAccessToken(
                                                       sessionInfo.getAccessToken()).withPreviousPassword(
                                                       passwordRequest.getOldPassword())
                                               .withProposedPassword(
                                                       passwordRequest.getNewPassword());
            ChangePasswordResult result =
                    mIdentityProvider.changePassword(changeRequest);
        }
        else
        {
            String msg = "Session login did not return access token.";
            throw new AWSCognitoIdentityProviderException(msg);
        }
    }

    @Override
    public void updateEmail(final String username, final String newEmail) throws
                                                                          AWSCognitoIdentityProviderException
    {
        AdminUpdateUserAttributesRequest updateRequest =
                new AdminUpdateUserAttributesRequest().withUsername(username)
                                                      .withUserPoolId(poolId)
                                                      .withUserAttributes(
                                                              new AttributeType().withName(
                                                                                         email)
                                                                                 .withValue(
                                                                                         newEmail),
                                                              new AttributeType().withName(
                                                                                         "emailVerified")
                                                                                 .withValue(
                                                                                         "true"));
        mIdentityProvider.adminUpdateUserAttributes(updateRequest);
    }

    @Override
    public void updateTempPassword(final PasswordRequest passwordRequest) throws
                                                                          AWSCognitoIdentityProviderException
    {

        final SessionInfo sessionInfo =
                sessionLogin(passwordRequest.getUsername(),
                             passwordRequest.getOldPassword());
        final String sessionString = sessionInfo.getSession();
        if (sessionString != null && sessionString.length() > 0)
        {
            Map<String, String> challengeResponses =
                    new HashMap<String, String>();
            challengeResponses.put(USERNAME, passwordRequest.getUsername());
            challengeResponses.put(PASSWORD, passwordRequest.getOldPassword());
            challengeResponses.put(NEW_PASSWORD,
                                   passwordRequest.getNewPassword());
            AdminRespondToAuthChallengeRequest changeRequest =
                    new AdminRespondToAuthChallengeRequest().withChallengeName(
                                                                    ChallengeNameType.NEW_PASSWORD_REQUIRED)
                                                            .withChallengeResponses(
                                                                    challengeResponses)
                                                            .withClientId(
                                                                    clientId)
                                                            .withUserPoolId(
                                                                    poolId)
                                                            .withSession(
                                                                    sessionString);
            AdminRespondToAuthChallengeResult challengeResponse =
                    mIdentityProvider.adminRespondToAuthChallenge(
                            changeRequest);
        }
    }

    @Override
    public void resetPassword(ResetPasswordRequest resetRequest) throws
                                                                 AWSCognitoIdentityProviderException
    {
        ConfirmForgotPasswordRequest passwordRequest =
                new ConfirmForgotPasswordRequest().withUsername(
                                                          resetRequest.getUsername()).withConfirmationCode(
                                                          resetRequest.getResetCode()).withClientId(clientId)
                                                  .withPassword(
                                                          resetRequest.getNewPassword());
        ConfirmForgotPasswordResult result =
                mIdentityProvider.confirmForgotPassword(passwordRequest);
    }

    @Override
    public void forgotPassword(final String username) throws
                                                      AWSCognitoIdentityProviderException
    {
        ForgotPasswordRequest passwordRequest =
                new ForgotPasswordRequest().withClientId(clientId)
                                           .withUsername(username);
        ForgotPasswordResult result =
                mIdentityProvider.forgotPassword(passwordRequest);
        CodeDeliveryDetailsType delivery = result.getCodeDeliveryDetails();
    }

    @Override
    public UserInfo getUserInfo(final String username) throws
                                                       AWSCognitoIdentityProviderException
    {
        AdminGetUserRequest userRequest =
                new AdminGetUserRequest().withUsername(username)
                                         .withUserPoolId(poolId);
        AdminGetUserResult userResult =
                mIdentityProvider.adminGetUser(userRequest);
        List<AttributeType> userAttributes = userResult.getUserAttributes();
        final String        resultUserName = userResult.getUsername();
        String              email          = null;
        for (AttributeType attr : userAttributes)
        {
            if (attr.getName().equals(email))
            {
                email = attr.getValue();
            }
        }
        UserInfo data = null;
        if (resultUserName != null && email != null)
        {
            data = new UserInfo(resultUserName, email);
        }
        return data;
    }

    @Override
    public UserInfo findUserByEmail(String email) throws
                                                  AWSCognitoIdentityProviderException
    {
        UserInfo data = null;
        if (email != null && email.length() > 0)
        {
            final String emailQuery = "email=\"" + email + "\"";
            ListUsersRequest usersRequest =
                    new ListUsersRequest().withUserPoolId(poolId)
                                          .withAttributesToGet(email)
                                          .withFilter(emailQuery);
            ListUsersResult usersResult =
                    mIdentityProvider.listUsers(usersRequest);
            List<UserType> users = usersResult.getUsers();
            if (users != null && users.size() > 0)
            {
                if (users.size() == 1)
                {
                    UserType     user     = users.get(0);
                    final String username = user.getUsername();
                    email = null;
                    List<AttributeType> attributes = user.getAttributes();
                    if (attributes != null)
                    {
                        for (AttributeType attr : attributes)
                        {
                            if (attr.getName().equals(email))
                            {
                                email = attr.getValue();
                            }
                        }
                        if (username != null && email != null)
                        {
                            data = new UserInfo(username, email);
                        }
                    }
                }
                else
                {
                    throw new DuplicateEmailException(
                            "Use a unique email " + "that is not " + " " +
                            email);
                }
            }
        }
        return data;
    }

    @Override
    public boolean hasUser(final String username)
    {
        boolean userExists = false;
        try
        {
            UserInfo data = getUserInfo(username);
            if (data != null && data.getUsername() != null &&
                data.getUsername().length() > 0 &&
                data.getUsername().equals(username))
            {
                userExists = true;
            }
        }
        catch (SdkBaseException ex)
        {
        }
        return userExists;
    }
}
