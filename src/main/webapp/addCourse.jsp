<%--
Author: Justin Hoang
Date: 2022-Mar-06-Sun
Time: 7:25 PM
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "contextPath" value = "${pageContext.request.contextPath}"/>
<c:import url = "resources/jsp/content-type.jsp"/>
<head>
    <c:import url = "resources/jsp/meta.jsp"/>
    <title>Add Course</title>
    <c:import url = "resources/jsp/css.jsp"/>
</head>
<body>
<c:import url = "resources/jsp/nav.jsp"/>
<div class = "container">
    <form id = "addCourseForm" role = "form" data-toggle = "validator"
          class = "form-horizontal"
          action = "addCourse"
          method = "POST">

        <div class = "form-group">
            <label class = "control-label col-sm-2" for = "name">Course
                                                                 Name</label>
            <div class = "col-sm-4">
                <input type = "text" class = "form-control" id = "name"
                       name = "name"
                       data-error = "Please enter the course name." required>
            </div>
            <div class = "help-block with-errors"></div>
        </div>


        <div class = "form-group">
            <label class = "control-label col-sm-2" for = "type">Course Type
            </label>
            <div class = "col-sm-4">
                <select class = "form-control" id = "type"
                        name = "type"
                        data-error = "Please select course type." required>
                    <c:forEach var = "type" items = "${courseTypes}">
                        <option value = "${courseType.id}">${courseType.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class = "help-block with-errors"></div>
        </div>

        <div class = "form-group">
            <label class = "control-label col-sm-2" for = "description">Description
            </label>
            <div class = "col-sm-4">
                <input type = "text" class = "form-control" id = "description"
                       name = "description"
                       data-error = "Please enter course description." required>
            </div>
            <div class = "help-block with-errors"></div>
        </div>

        <button type = "submit" class = "btn btn-default col-sm-offset-3"
                data-disable = "true">Submit
        </button>
        <button type = "reset" class = "btn btn-default">Clear</button>

    </form>
</div>

</body>
</html>
