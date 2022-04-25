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
    <title>Learn Fast: Free, Private & Secure Community</title>
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

            <!--   Icon Section   -->
            <div class = "row">

                <div class = "col s12 m4">
                    <div class = "icon-block">
                        <h2 class = "center materialize-red-text">
                            <i
                                    class = "material-icons">
                                flash_on</i></h2>

                        <div class = "center">
                            <h5 class = "center">Speeds up
                                                 learning</h5>
                            <img class = "center"
                                 src = "resources/img/bear1-index.jpg"
                                 width
                                         = "150" alt = "bear"/>
                        </div>
                    </div>
                </div>

                <div class = "col s12 m4">
                    <div class = "icon-block">
                        <h2 class = "center materialize-red-text">
                            <i
                                    class = "material-icons">
                                group</i></h2>

                        <div class = "center">
                            <h5 class = "center">Experience
                                                 Focused</h5>
                            <img class = "center"
                                 src = "resources/img/bear2-index.jpg"
                                 width =
                                         "150" alt = "bear"/>
                        </div>
                    </div>
                </div>

                <div class = " col s12 m4">
                    <div class = "icon-block">
                        <h2 class = "center materialize-red-text">
                            <i
                                    class = "material-icons">
                                settings</i></h2>
                        <div class = "center">
                            <h5 class = "center">Easy to
                                                 use</h5>
                            <img class = "center"
                                 src = "resources/img/bear3-index.jpg"
                                 width =
                                         "150" alt = "bear"/>
                        </div>
                    </div>
                </div>

            </div>
            <br><br>
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
</html>

