<%--
Author: Justin Hoang
Date: 2022-Mar-20-Sun
Time: 11:01 PM
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
    <title>Learn Fast</title>
</head>

<body>
<!--NAV TOP-->
<div class = "fixed-header">
    <div class = "containerx">
        <nav class = "sticky materialize-red lighten-2"
             role = "navigation">
            <div class = "nav-wrapper container">
                <ul class = "right hide-on-med-and-down">
                    <li><a class = "materialize-red white-text btn"
                           href = "login">Create
                                          an
                                          account</a>
                    </li>
                </ul>
                <ul class = "right hide-on-small-and-down hide-on-med-and-up">
                    <li><a class = "materialize-red white-text btn"
                           href = "login">Get
                                          Learn
                                          Fast</a>
                    </li>
                </ul>

                <ul class = "left show-on-small">
                    <li><a id = "logo-container" href = "#"
                           class = "left brand-logo show-on-small">Learn
                                                                   Fast</a>
                    </li>
                </ul>
                <ul class = "right show-on-small">
                    <li><a class = "white materialize-red-text btn"
                           href = "login">Sign
                                          in</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>
<!--NAV TOP END-->

<div class = "container">
<!--HEADER-->
<header class = "page-header">
    <div class = "section no-pad-bot" id = "index-banner">

        <div class = "container">
            <br><br>
            <h1 class = "header center">Learn Fast: Java Web
                                        Application</h1>
            <div class = "row center">
                <h5 class = "header col s12 light">A modern social
                                                   connection
                                                   and
                                                   learning
                                                   management
                                                   system
                                                   for mentors and
                                                   mentees</h5>
            </div>

            <div class = "row center">
                <div class = "container-fluid">
                    <a href = "login"
                       class = "btn-large materialize-red lighten-2">Create
                                                                     an
                                                                     account</a>
                </div>
            </div>
            <br><br>
        </div>
    </div>
</header>
<!--HEADER END-->

<!--MAIN-->
<main id = "main">

<div class="container">
<div style = "padding-top: 1em;"></div>
<div class = "row">
    <div class = "col-md-12">
        <h2 align = "center">Create a new user account</h2>
    </div>
</div>
<!-- row -->
<div class = "row">
    <div class = "col-md-2"></div>
    <div class = "col-md-10">
        An email with an account creation code will be sent to your email
        address.
    </div>
</div>
<div style = "padding-top: 1em;"></div>
<c:if test = "${createUserError != null && createUserError.length() > 0}">
    <div class = "row">
        <div class = "col-md-2"></div>
        <div class = "col-md-8">
            <div class = "box inputError">${createUserError}</div>
        </div>
        <div class = "col-md-2"></div>
    </div>
</c:if>
<div class="row">
<div class="col-md-12">
<!-- Post to the login controller -->
<form action="/create-user-form" method="post">
<c:if test = "${userNameError != null && userNameError.length() > 0}">
    <div class = "form-group row">
        <div class = "col-sm-4"></div>
        <div class = "col-sm-8">
            <span class = "inputError">${userNameError}</span>
        </div>
    </div>
</c:if>
<div class = "form-group row">
    <label for = "title" class = "col-sm-4 col-form-label">User name:</label>

    <c:choose>
        <c:when test = "${userNameVal != null && userNameVal.length() > 0}">
            <input type = "text" id = "user_name" name = "user_name"
                   value = "${userNameVal}">
        </c:when>
        <c:otherwise>
            <div class = "col-sm-8">
                <input type = "text" id = "username" name = "user_name"
                       placeholder = "User name">
            </div>
            <!-- col-md-8 -->
        </c:otherwise>
    </c:choose>
</div>
<!-- form-group row -->
<c:if test = "${emailError != null && emailError.length() > 0}">
    <div class = "form-group row">
        <div class = "col-sm-4"></div>
        <div class = "col-sm-8">
            <span class = "inputError">${emailError}</span>
        </div>
    </div>
</c:if>
<div class = "form-group row">
    <label for = "title" class = "col-sm-4 col-form-label">Email:</label>
    <div class = "col-sm-8">
        <input type = "text" id = "email" name = "email" placeholder = "Email">
    </div> <!-- col-sm-8 -->
</div>
<!-- form-group row -->
<c:if test = "${locationError != null && locationError.length() > 0}">
    <div class="form-group row">
    <div class="col-sm-4"></div>
    <span class="inputError">${locationError}</span>
    <div class="col-sm-8">
    </div>
    </div>

    <!-- col-sm-8 -->
    </div> <!-- form-group row -->
    <div class="form-group row">
    <div class="col-sm-4"></div>
    <div class="col-sm-8">
    <span>
    <button type="submit" class="btn btn-primary">Create User</button>
    </span>
    <span>
    <a href="<c:url
        value = "/"/>" id="cancel" name="cancel" class="btn btn-primary">Cancel</a>
    </span>
    </div>
    </div>
    </form>
    </div> <!-- col-md-12 -->
    </div> <!-- row -->
    </div> <!-- container -->
    </main>
    <!--MAIN END-->
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

