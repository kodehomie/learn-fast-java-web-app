<%--
Author: Justin Hoang
Date: 2022-Mar-21-Mon
Time: 6:09 PM
--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html class = " ">
<jsp:include page="head.jsp" />
<body class = "html" data-header = "colored" data-footer = "light"
      data-header_align = "center" data-menu_type = "left" data-menu = "colored"
      data-menu_icons = "on" data-footer_type = "left" data-site_mode = "light"
      data-footer_menu = "show" data-footer_menu_style = "colored">

<jsp:include page="navj.jsp" />

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
</div>

<hr/>

<div class = "container">
    <section class = "section">
        <a href = "userCreateForm" class = "green btn">Create
                                                       User</a>
        <br/><br/>
        <table id = "dataTable"
               class = "display nowrap"
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

<jsp:include page = "footer.jsp"/>
<jsp:include page = "js.jsp"/>
<script>
    $(document).ready(function () {
        $('#userTable').DataTable({
            "scrollY": 500,
            "scrollX": true,
            "paging": true
        });
    });

    if ("serviceWorker" in navigator) {
        if (navigator.serviceWorker.controller) {
            console.log("[PWA Builder] active service worker found, no need to register");
        } else {
            navigator.serviceWorker
                .register("pwabuilder-sw.js", {
                    scope: "./"
                })
                .then(function (reg) {
                    console.log("[PWA Builder] Service worker has been registered for scope: " + reg.scope);
                });
        }
    }
    document.addEventListener("DOMContentLoaded", function () {
        $('.preloader-background').delay(10).fadeOut('slow');
    });
</script>
<%--JAVASCRIPT END--%>
</body>
</html>
