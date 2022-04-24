<%--
Author: Justin Hoang
Date: 2022-Apr-23-Sat
Time: 4:52 PM
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
    <title>Learn Fast: Delete Account</title>
</head>
<body>
<div class = "container">

    <!--HEADER-->
    <header class = "page-header">
        <div class = "section no-pad-bot" id = "index-banner">

            <div class = "container">
                <br><br>
                <h1 class = "header center">Delete Account</h1>
                <br><br>
            </div>
        </div>
    </header>
    <!--HEADER END-->

    <form action = "account-delete-form" method = "POST">
        <!-- Password -->
        <c:if test = "${passwordError != null && passwordError.length() > 0}">

        <div class = "row">
            <div class = "input-field col s12">
                <span class = "inputError">${passwordError}</span>
            </div>

            </c:if>

            <div class = "row">
                <div class = "input-field col s12">
                    <input type = "password" id = "password" name = "password"
                           placeholder = "Password">
                    <label for = "password">Password:</label>
                </div>
            </div>

            <div class = "row">
                <div class = "input-field col s12">
                <span>
                    <button type = "submit"
                            class = "btn green">Delete Account</button>
                </span>
                    <span>
                    <a href = "<c:url value="/" />" id = "cancel"
                       class = "btn black">Cancel</a>
                </span>
                </div>
            </div>

    </form>
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
