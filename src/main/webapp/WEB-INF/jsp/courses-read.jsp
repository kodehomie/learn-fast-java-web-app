<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "contextPath" value = "${pageContext.request.contextPath}"/>
<c:import url = "resources/jsp/content-type.jsp"/>
<c:set var = "title" value = "Courses"/>
<head>
    <c:import url = "resources/jsp/meta.jsp"/>
    <title>${title}</title>
    <c:import url = "resources/jsp/css.jsp"/>
</head>
<body>

<div class = "section no-pad-bot" id = "index-banner">
    <div class = "container">
        <br><br>
        <h1 class = "header center">Courses</h1>
        <div class = "row center">
            <h5 class = "header col s12 light"></h5>
        </div>

        <div class = "centered highlight">
            <h2></h2>
            <%--    ${courses}--%>
            <table class = "responsive-table centered highlight">
                <thead class = "">
                <th scope = "col">ID</th>
                <th scope = "col">Title</th>
                <th scope = "col">Section</th>
                <th scope = "col">Format</th>
                <th scope = "col">Mentor</th>
                <th scope = "col">Section Status</th>
                <th scope = "col">Meets</th>
                <th scope = "col">Dates</th>
                <th scope = "col">Description</th>
                </thead>
                <tbody>
                <jsp:useBean id="courses" scope="session" type="java.util.List"/>
                <c:forEach var = "course" items = "${courses}">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.title}</td>
                        <td>${course.section}</td>
                        <td>${course.format}</td>
                        <td>${course.mentor}</td>
                        <td>${course.sectionStatus}</td>
                        <td>${course.meets}</td>
                        <td>${course.dates}</td>
                        <td>${course.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <br><br>

</div>

</body>
</html>