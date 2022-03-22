<%--
Author: Justin Hoang
Date: 2022-Mar-21-Mon
Time: 6:09 PM
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
    <%--DATATABLES CSS--%>
    <link type = "text/css" rel = "stylesheet"
          href = "https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link type = "text/css" rel = "stylesheet"
          href = "resources/css/dataTables.material.min.css.css"
          media = "screen,projection"/>
    <link type = "text/css" rel = "stylesheet"
          href = "resources/css/jquery.dataTables.min.css.css"
          media = "screen,projection"/>
    <%--TITLE--%>
    <title>User Listing</title>
</head>
<body>
<%--TOP NAV--%>
<nav class = "sticky materialize-red lighten-2" id = "nav" role = "navigation">
    <div class = "navbar-fixed">

        <ul class = "left show-on-small">
            <li><a id = "logo-container" href = "${pageContext.request.contextPath}/welcome"
                   class = "left brand-logo show-on-small">Learn Fast</a></li>
        </ul>
        <ul id = "nav-mobile" class = "right hide-on-small-only">
            <li><a href = "usersRead">User Listing</a></li>
            <li><a href = "#">2</a></li>
            <li><a href = "#">3</a></li>
        </ul>

    </div>
</nav>
<%--TOP NAV END--%>

<div id = "page-container">
    <div id = "content-wrap">
        <div class = "content" id = "content">

            <div class = "section no-pad-bot" id = "index-banner">
                <div class = "container">
                    <br><br>
                    <h1 class = "header center">User Listing</h1>
                    <div class = "row center">
                        <h5 class = "header col s12 light"></h5>
                    </div>
                    <br><br>
                </div>
            </div>


            <hr/>
            <div class = "container">
                <section class = "section">
                    <a href = "userCreateForm" class = "green btn">Create
                                                                   User</a>
                    <br/><br/>
                    <table id = "userTable" class = "mdl-data-table responsive-table"
                           style = "width:100%">
                        <thead>
                        <tr>
                            <th>Username</th>
                            <th>Birthdate</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Gender</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>Update || Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%--TRAVERSE USERS--%>
                        <c:forEach var = "tmpUser"
                                   items = "${users}">
                            <%--UPDATE--%>
                            <c:url var = "updateLink"
                                   value = "/user/userUpdateForm">
                                <c:param name = "id"
                                         value = "${tmpUser.id}"/>
                            </c:url>
                            <%--DELETE--%>
                            <c:url var = "deleteLink"
                                   value = "/user/userDelete">
                                <c:param name = "id"
                                         value = "${tmpUser.id}"/>
                            </c:url>
                            <tr>
                                <td>${tmpUser.username}</td>
                                <td>${tmpUser.birthdate}</td>
                                <td>${tmpUser.givenName}</td>
                                <td>${tmpUser.familyName}</td>
                                <td>${tmpUser.gender}</td>
                                <td>${tmpUser.email}</td>
                                <td>${tmpUser.phoneNumber}</td>
                                <td>
                                        <%--UPDATE--%>
                                    <a href = "${updateLink}"
                                       class = "green btn white-text">Update</a>
                                    || <a href = "${deleteLink}"
                                          class = "materialize-red btn white-text"
                                          onclick = "if (!(confirm('Do you intend to delete user?'))) return false">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </section>
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
<script type = "text/javascript"
        src = "resources/js/jquery.dataTables.min.js"></script>
<script type = "text/javascript"
        src = "resources/js/dataTables.material.min.js"></script>
<script type = "text/javascript"
        src = "https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#userTable').DataTable({
            autoWidth: false,
            columnDefs: [
                {
                    targets: ['_all'],
                    className: 'mdc-data-table__cell'
                }
            ]
        });
    });
</script>
<%--JAVASCRIPT END--%>
</body>
<!--NAV-->
<div class = "bottomNav">
    <nav class = "navbar fixed-bottom materialize-red lighten-2"
         role = "navigation">
        <div class = "nav-wrapper container">

            <div class = "center container">
                <ul class = "center container" id = "nav-bottom">
                    <li><a href = "welcome"><i class = "material-icons">home</i></a>
                    </li>
                    <li><a href = "#"><i class = "material-icons">search</i></a>
                    </li>
                    <li><a href = "#"><i
                            class = "material-icons">ondemand_video</i></a>
                    </li>
                    <li><a href = "#"><i class = "material-icons">shop</i></a>
                    </li>
                    <li><a href = "#"><i class = "material-icons">chat</i></a>
                    </li>
                    <li><a href = "#"><i class = "material-icons">person_pin</i></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!--NAV END-->
</html>
