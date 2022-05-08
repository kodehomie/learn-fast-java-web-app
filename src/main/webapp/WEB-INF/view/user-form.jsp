<%--
Author: Justin Hoang
Date: 2022-Mar-21-Mon
Time: 5:44 PM
--%>
<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<c:set var = "contextPath" value = "${pageContext.request.contextPath}"/>
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
<jsp:include page = "footer.jsp"/>
<jsp:include page = "js.jsp"/>
</body>
</html>
