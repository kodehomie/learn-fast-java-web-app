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
<%--<div class = "container">--%>
<%--    <form id = "createCourseForm" role = "form" data-toggle = "validator"--%>
<%--          class = "form-horizontal"--%>
<%--          action = "addCourse"--%>
<%--          method = "POST">--%>

<%--        <div class = "form-group">--%>
<%--            <label class = "control-label col-sm-2" for = "name">Course--%>
<%--                                                                 Name</label>--%>
<%--            <div class = "col-sm-4">--%>
<%--                <input type = "text" class = "form-control" id = "name"--%>
<%--                       name = "name"--%>
<%--                       data-error = "Please enter the course name." required>--%>
<%--            </div>--%>
<%--            <div class = "help-block with-errors"></div>--%>
<%--        </div>--%>


<%--        <div class = "form-group">--%>
<%--            <label class = "control-label col-sm-2" for = "type">Course Type--%>
<%--            </label>--%>
<%--            <div class = "col-sm-4">--%>
<%--                <select class = "form-control" id = "type"--%>
<%--                        name = "type"--%>
<%--                        data-error = "Please select course type." required>--%>
<%--                    <c:forEach var = "type" items = "${courseFormats}">--%>
<%--                        <option value = "${courseFormat.id}">${courseFormat.name}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <div class = "help-block with-errors"></div>--%>
<%--        </div>--%>

<%--        <div class = "form-group">--%>
<%--            <label class = "control-label col-sm-2" for = "description">Description--%>
<%--            </label>--%>
<%--            <div class = "col-sm-4">--%>
<%--                <input type = "text" class = "form-control" id = "description"--%>
<%--                       name = "description"--%>
<%--                       data-error = "Please enter course description." required>--%>
<%--            </div>--%>
<%--            <div class = "help-block with-errors"></div>--%>
<%--        </div>--%>

<%--        <button type = "submit" class = "btn btn-default col-sm-offset-3"--%>
<%--                data-disable = "true">Submit--%>
<%--        </button>--%>
<%--        <button type = "reset" class = "btn btn-default">Clear</button>--%>

<%--    </form>--%>
<%--</div>--%>
<div class = "section no-pad-bot" id = "index-banner">
    <div class = "container">
        <br><br>
        <h1 class = "header center">Create Course</h1>
        <div class = "row center">
            <h5 class = "header col s12 light"></h5>
        </div>
        <div class = "row center">
            <form id = "createCourseForm" role = "form"
                  class = "col s12"
                  action = "createCourse"
                  method = "POST">
                <div class = "row">
                    <div class = "input-field col s12">
                        <i class = "material-icons prefix">create</i>
                        <input placeholder = "Course Title" id = "title"
                               type = "text" class = "validate">
                        <label for = "title"></label>
                    </div>
                </div>

                <div class = "row">
                    <div class = "input-field col s12">
                        <i class = "material-icons prefix">group</i>
                        <input placeholder = "Course Section" id = "section" type = "text"
                               class = "validate">
                    </div>
                </div>

                <div class = "row">
                    <div class = "input-field col s12">
                        <i class = "material-icons prefix">add_location</i>
                        <input placeholder = "Course Format" id = "format"
                               type = "text"
                               class = "validate">
                    </div>
                </div>

                <div class = "row">
                    <div class = "input-field col s12">
                        <i class = "material-icons prefix">person</i>
                        <input placeholder = "Course Mentor" id = "mentor"
                               type = "text"
                               class = "validate">
                    </div>
                </div>

                <div class = "row">
                    <div class = "input-field col s12">
                        <i class = "material-icons prefix">access_time</i>
                        <input placeholder = "Course Meeting Days" id = "meets"
                               type = "text"
                               class = "validate">
                    </div>
                </div>

                <div class = "row">
                    <div class = "input-field col s12">
                        <i class = "material-icons prefix">date_range</i>
                        <input placeholder = "Course Meeting Dates" id = "dates"
                               type = "text"
                               class = "validate">
                    </div>
                </div>


                <a input type = "submit" value = "Next"
                   class = "materialize-red lighten-2 btn-large">Next</a>


            </form>
        </div>
        <br><br>

    </div>
</div>

</body>
</html>
