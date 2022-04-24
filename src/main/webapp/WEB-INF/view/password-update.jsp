<%--
Author: Justin Hoang
Date: 2022-Apr-23-Sat
Time: 4:51 PM
--%>
<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
    <%--META--%>
    <meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">
    <meta name = "viewport" content = "width=device-width, initial-scale=1">
    <%--CSS--%>
    <link type = "text/css" rel = "stylesheet"
          href = "resources/css/style.css"
          media = "screen,projection"/>
    <%--MATERIALIZE CSS--%>
    <link type = "text/css" rel = "stylesheet"
          href = "https://fonts.googleapis.com/icon?family=Material+Icons">
    <link type = "text/css" rel = "stylesheet"
          href = "resources/css/materialize.css"
          media = "screen,projection"/>
    <link type = "text/css" rel = "stylesheet"
          href = "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"
          media = "screen,projection">
    <%--TITLE--%>
    <title>Learn Fast: Update Password</title>
</head>
<body>
<div class = "container">
    <!--HEADER-->
    <header class = "page-header">
        <div class = "section no-pad-bot" id = "index-banner">

            <div class = "container">
                <br><br>
                <h1 class = "header center">Update Password</h1>
                <br><br>
            </div>
        </div>
    </header>
    <!--HEADER END-->

    <!--MAIN-->
    <main id = "main">

        <c:if test = "${passwordUpdateError != null && passwordUpdateError.length() > 0}">

            <div class = "row">
                <div class = "input-field col s12">
                    <div class = "box inputError">${passwordUpdateError}</div>
                </div>
            </div>

        </c:if>

        <form action = "/password-update-form" method = "post">

            <c:if test = "${usernameError != null && usernameError.length() > 0}">

                <div class = "row">
                    <div class = "input-field col s12">
                        <span class = "inputError">${usernameError}</span>
                    </div>
                </div>

            </c:if>
            <c:choose>
                <c:when test = '${changeType != null && changeType.equals("password-update")}'>
                    <input class = "invisible" type = "text" id = "username"
                           name = "username" value = "${usernameVal}">
                </c:when>

                <c:otherwise>
                    <div class = "row">
                        <div class = "input-field col s12">


                            <c:choose>
                                <c:when test = "${usernameVal != null && usernameVal.length() > 0}">

                                    <input type = "text" id = "username"
                                           name = "username"
                                           value = "${usernameVal}">

                                </c:when>

                                <c:otherwise>

                                    <input type = "text" id = "username"
                                           name = "username"
                                           value = "${usernameVal}"
                                           placeholder = "Username">

                                </c:otherwise>
                            </c:choose>
                            <label for = "username">Username: </label>
                        </div>
                    </div>

                </c:otherwise>
            </c:choose>

            <c:if test = "${oldPasswordError != null && oldPasswordError.length() > 0}">

                <div class = "row">
                    <div class = "input-field col s12">
                        <span class = "inputError">${oldPasswordError}</span>
                    </div>
                </div>

            </c:if>

            <div class = "row">
                <div class = "input-field col s12">
                    <input type = "password" id = "oldPassword"
                           name = "oldPassword" placeholder = "Password">
                    <label for = "oldPassword">Current Password:</label>
                </div>
            </div>


            <c:if test = "${newPasswordError != null && newPasswordError.length() > 0}">

                <div class = "row">
                    <div class = "input-field col s12">
                        <span class = "inputError">${newPasswordError}</span>
                    </div>
                </div>

            </c:if>
            <div class = "row">
                <div class = "input-field col s12">
                    <input type = "password" id = "newPassword"
                           name = "newPassword"
                           placeholder = "New Password">
                    <label for = "newPassword">Current Password:</label>
                </div>
            </div>


            <c:if test = "${verifyPasswordError != null && verifyPasswordError.length() > 0}">
                <div class = "row">
                    <div class = "input-field col s12">
                        <span class = "inputError">${verifyPasswordError}</span>
                    </div>
                </div>

            </c:if>

            <div class = "row">
                <div class = "input-field col s12">
                    <input type = "password" id = "verifyPassword"
                           name = "verifyPassword"
                           placeholder = "Password">
                    <label>Verify Password:</label>
                </div>
            </div>

            <div class = "row">
                <div class = "input-field col s12">
                        <span>
                            <button type = "submit" class = "btn green">Change Password</button>
                        </span>
                    <span>
                            <a href = "<c:url value="/setup.jsp" />"
                               id = "cancel"
                               class = "btn black">Cancel</a>
                        </span>
                </div>
            </div>

        </form>

    </main>
</div>

<%--JAVASCRIPT--%>
<script type = "text/javascript"
        src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script type = "text/javascript" src = "resources/js/init.js"></script>
<script type = "text/javascript"
        src = "resources/js/materialize.js"></script>
<%--JAVASCRIPT END--%>
</body>
<!--FOOTER-->
<div class = "fixed-footer">
    <div class = "containerx">
        <footer class = "page-footer materialize-red lighten-2"
                id = "footer">
            <div class = "container">
                <div class = "row">
                    <div>
                        <a class = "white-text" href = "#!">Privacy</a>
                        <a class = "white-text" href = "#!">Terms</a>
                        <a class = "white-text" href = "#!">About Learn
                                                            Fast</a>
                        <a class = "white-text" href = "#!">Products</a>
                        <a class = "white-text" href = "#!">Policy</a>
                        <a class = "white-text" href = "#!">Privacy &
                                                            Security</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<!--FOOTER END-->

</html>

