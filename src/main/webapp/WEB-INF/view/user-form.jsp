<%--
Author: Justin Hoang
Date: 2022-Mar-21-Mon
Time: 5:44 PM
--%>
<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
                    <li><a id = "logo-container"
                           href = "${pageContext.request.contextPath}/welcome"
                           class = "left brand-logo show-on-small">Learn
                                                                   Fast</a></li>
                </ul>
                <ul id = "nav-mobile" class = "right hide-on-small-only">
                    <li><a href = "usersRead">User Listing</a></li>
                    <li><a href = "coursesRead">Course Listing</a></li>
                    <li><a href = "groupsRead">Group Listing</a></li>
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

<footer class = "page-footer">
    <div class = "container footer-content">
        <div class = "row">
            <div class = "">
                <h5 class = "logo">Learn Fast</h5>
                <p class = "text">A modern social connection and learning
                                  management system for mentors and mentees.</p>
            </div>
            <div class = "link-wrap">
                <ul class = "link-ul">
                    <li><a class = "white-text" href = "#!"><i
                            class = "mdi mdi-phone"></i> +1 234 567 890</a>
                    </li>
                    <li><a class = "white-text" href = "#!"><i
                            class = "mdi mdi-email"></i>
                        jhoang1@madisoncollege.edu</a>
                    </li>
                    <li><a class = "white-text" href = "#!"><i
                            class = "mdi mdi-map-marker"></i> 123 Street,
                                                              Madison, WI,
                                                              USA</a></li>
                </ul>
                <ul class = "social-wrap">
                    <li class = "social">
                        <a class = "" href = "#!"><i
                                class = "mdi mdi-facebook"></i></a>
                        <a class = "" href = "#!"><i
                                class = "mdi mdi-twitter"></i></a>
                        <a class = "" href = "#!"><i
                                class = "mdi mdi-dribbble"></i></a>
                        <a class = "" href = "#!"><i
                                class = "mdi mdi-google-plus"></i></a>
                        <a class = "" href = "#!"><i
                                class = "mdi mdi-linkedin"></i></a>

                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class = "footer-copyright">
        <div class = "container">
            Built by: Justin Hoang
        </div>
    </div>
</footer>
<%--JAVASCRIPT--%>
<script type = "text/javascript"
        src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type = "text/javascript"
        src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script type = "text/javascript" src = "resources/js/init.js"></script>
<script type = "text/javascript" src = "resources/js/materialize.js"></script>
<%--JAVASCRIPT END--%>
</body>
</html>
