<%--
Author: Justin Hoang
Date: 2022-Mar-21-Mon
Time: 5:44 PM
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
    <title>User Form</title>
</head>
<body>
<%--TOP NAV--%>
<div class = "fixed-header">
    <div class = "containerx">
        <nav class = "materialize-red lighten-2" id = "nav"
             role = "navigation">
            <div class = "navbar-fixed">

                <ul class = "left show-on-small">
                    <li><a id = "logo-container" href = "welcome"
                           class = "left brand-logo show-on-small">Learn
                                                                   Fast</a></li>
                </ul>
                <ul id = "nav-mobile" class = "right hide-on-small-only">
                    <li><a href = "usersRead">User Listing</a></li>
                    <li><a href = "#">2</a></li>
                    <li><a href = "#">3</a></li>
                </ul>

            </div>
        </nav>
    </div>
</div>
<%--TOP NAV END--%>

<div class = "container">
    <div id = "page-container">
        <div id = "content-wrap">
            <div class = "content" id = "content">
                <div class = "section no-pad-bot" id = "index-banner">
                    <div class = "container">
                        <br><br>
                        <h1 class = "header center">User Data</h1>
                        <div class = "row center">
                            <h5 class = "header col s12 light"></h5>
                        </div>
                        <br><br>

                    </div>
                </div>

                <hr/>
                <div class = "container">
                    <section class = "section">
                        <table class = "responsive-table">
                            <form:form action = "userCreate"
                                       cssClass = "form-horizontal"
                                       method = "post" modelAttribute = "user">

                                <form:hidden path = "id"/>

                                <div class = "form-group">
                                    <label for = "birthdate"
                                           class = "control-label">Birthdate</label>
                                    <div class = "col-md-9">
                                        <form:input path = "birthdate"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "email"
                                           class = "control-label">Email</label>
                                    <div class = "col-md-9">
                                        <form:input path = "email"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "phoneNumber"
                                           class = "control-label">Phone
                                                                   Number</label>
                                    <div class = "col-md-9">
                                        <form:input path = "phoneNumber"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "givenName"
                                           class = "control-label">First
                                                                   Name</label>
                                    <div class = "col-md-9">
                                        <form:input path = "givenName"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "familyName"
                                           class = "control-label">Last
                                                                   Name</label>
                                    <div class = "col-md-9">
                                        <form:input path = "familyName"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "gender"
                                           class = "control-label">Gender</label>
                                    <div class = "col-md-9">
                                        <form:input path = "gender"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "username"
                                           class = "control-label">Username</label>
                                    <div class = "col-md-9">
                                        <form:input path = "username"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "password"
                                           class = "control-label">Password</label>
                                    <div class = "col-md-9">
                                        <form:input path = "password"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>


                                <div class = "form-group">
                                    <!-- Button -->
                                    <div class = "">
                                        <form:button
                                                class = "green btn">Submit</form:button>
                                    </div>
                                </div>

                            </form:form>
                        </table>
                    </section>
                </div>
            </div>
        </div>
    </div>
</div>
<%--JAVASCRIPT--%>
<script type = "text/javascript"
        src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type = "text/javascript"
        src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script type = "text/javascript" src = "resources/js/init.js"></script>
<script type = "text/javascript" src = "resources/js/materialize.js"></script>
<%--JAVASCRIPT END--%>
</body>
<%--NAV--%>
<div class = "fixed-footer">
    <div class = "containerx">
        <footer class = "page-footer materialize-red lighten-2"
                id = "footer">
            <nav class = "materialize-red lighten-2"
                 role = "navigation">
                <div class = "nav-wrapper container">
                    <div class = "center container">
                        <ul class = "center container" id = "nav-bottom">
                            <li><a href = "welcome"><i
                                    class = "material-icons">home</i></a>
                            </li>
                            <li><a href = "#"><i
                                    class = "material-icons">search</i></a>
                            </li>
                            <li><a href = "#"><i
                                    class = "material-icons">ondemand_video</i></a>
                            </li>
                            <li><a href = "#"><i
                                    class = "material-icons">shop</i></a>
                            </li>
                            <li><a href = "#"><i
                                    class = "material-icons">chat</i></a>
                            </li>
                            <li><a href = "#"><i
                                    class = "material-icons">person_pin</i></a>
                            </li>
                        </ul>
                    </div>
                    </ul>
                </div>
            </nav>
        </footer>
    </div>
</div>
<%--NAV END--%>
</html>
