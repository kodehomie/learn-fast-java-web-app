<%--
Author: Justin Hoang
Date: 2022-Apr-23-Sat
Time: 4:47 PM
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
    <title>Learn Fast: Account</title>
</head>
<body>
<div class = "container">
    <!--HEADER-->
    <header class = "page-header">
        <div class = "section no-pad-bot" id = "index-banner">

            <div class = "container">
                <br><br>
                <h1 class = "header center">${userInfo.getUsername()} is
                                                                      currently
                                                                      logged
                                                                      in.</h1>
                <br><br>
            </div>
        </div>
    </header>
    <!--HEADER END-->

    <!--MAIN-->
    <main id = "main">

        <div class = "row">
            <div class = "col s12">
                <h2>Profile</h2>
                <div>Email: ${userInfo.getEmail()}</div>
            </div>
        </div>

        <div class = "row">
            <div class = "col s12">
                <ul>
                    <li><a href = "<c:url value="/password-update" />">Update
                                                                       Password</a>
                    </li>
                    <li><a href = "<c:url value="/email-update" />">Update
                                                                    Email</a>
                    </li>
                    <li><a href = "<c:url value="/profile-update" />">Update
                                                                      Profile</a>
                    </li>
                    <li><a href = "<c:url value="/account-delete" />">Delete
                                                                      Account</a>
                    </li>
                </ul>
            </div>
        </div>

        <form action = "logout-form" method = "post">
            <div class = "row">
                <div class = "input-field col s12">
                    <button type = "submit" class = "btn green">Logout</button>
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
