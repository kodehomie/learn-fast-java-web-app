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
<jsp:include page = "head.jsp"/>
<body>
<jsp:include page = "navj.jsp"/>
<div class = "container">
    <div id = "page-container">
        <div id = "content-wrap">
            <div class = "content" id = "content">
                <div class = "section no-pad-bot" id = "index-banner">
                    <div class = "container">
                        <br><br>
                        <h1 class = "header center">Course Data</h1>
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
                            <form:form action = "courseCreate"
                                       cssClass = "form-horizontal"
                                       method = "post"
                                       modelAttribute = "course">

                                <form:hidden path = "id"/>

                                <div class = "form-group">
                                    <label for = "title"
                                           class = "control-label">Title</label>
                                    <div class = "col-md-9">
                                        <form:input path = "title"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "section"
                                           class = "control-label">Section</label>
                                    <div class = "col-md-9">
                                        <form:input path = "section"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "format"
                                           class = "control-label">Format</label>
                                    <div class = "col-md-9">
                                        <form:input path = "format"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "mentor"
                                           class = "control-label">Mentor</label>
                                    <div class = "col-md-9">
                                        <form:input path = "mentor"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "sectionStatus"
                                           class = "control-label">Section
                                                                   Status</label>
                                    <div class = "col-md-9">
                                        <form:input path = "sectionStatus"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "meets"
                                           class = "control-label">Meets</label>
                                    <div class = "col-md-9">
                                        <form:input path = "meets"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "dates"
                                           class = "control-label">Dates</label>
                                    <div class = "col-md-9">
                                        <form:input path = "dates"
                                                    cssClass = "form-control"/>
                                    </div>
                                </div>

                                <div class = "form-group">
                                    <label for = "description"
                                           class = "control-label">Description</label>
                                    <div class = "col-md-9">
                                        <form:input path = "description"
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
<jsp:include page = "footer.jsp"/>
<jsp:include page = "js.jsp"/>
</body>
</html>
