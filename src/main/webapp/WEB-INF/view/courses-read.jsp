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
            <h1 class = "header center">Course Listing</h1>
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
        <a href = "courseCreateForm" class = "green btn">Create
                                                         Course</a>
        <br/><br/>
        <table id = "dataTable"
               class = "display nowrap"
               style = "width:100%">
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Section #</th>
                <th>Format</th>
                <th>Mentor</th>
                <th>Section Status</th>
                <th>Meets</th>
                <th>Dates</th>
                <th>Description</th>
                <th>Update || Delete</th>
            </tr>
            </thead>
            <tbody>
            <%--TRAVERSE COURSES--%>
            <c:forEach var = "tmpCourse"
                       items = "${courses}">
                <%--UPDATE--%>
                <c:url var = "updateLink"
                       value = "/course/courseUpdateForm">
                    <c:param name = "id"
                             value = "${tmpCourse.id}"/>
                </c:url>
                <%--DELETE--%>
                <c:url var = "deleteLink"
                       value = "/course/courseDelete">
                    <c:param name = "id"
                             value = "${tmpCourse.id}"/>
                </c:url>
                <tr>
                    <td>${tmpCourse.id}</td>
                    <td>${tmpCourse.title}</td>
                    <td>${tmpCourse.section}</td>
                    <td>${tmpCourse.format}</td>
                    <td>${tmpCourse.mentor}</td>
                    <td>${tmpCourse.sectionStatus}</td>
                    <td>${tmpCourse.meets}</td>
                    <td>${tmpCourse.dates}</td>
                    <td>${tmpCourse.description}</td>
                    <td>
                            <%--UPDATE--%>
                        <a href = "${updateLink}"
                           class = "green btn white-text">Update</a>
                        || <a href = "${deleteLink}"
                              class = "materialize-red btn white-text"
                              onclick = "if (!(confirm('Do you intend to delete course?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</div>

<jsp:include page = "footer.jsp"/>
<jsp:include page = "js.jsp"/>
</body>
</html>
