<%--
Author: Justin Hoang
Date: 2022-Feb-28-Mon
Time: 6:21 PM
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="resources/jsp/content-type.jsp"/>
<head>
    <c:import url="resources/jsp/meta.jsp"/>
    <title>Learn Fast: Free, Private & Secure Community</title>
    <c:import url="resources/jsp/css.jsp"/>
</head>
<body>
<c:import url="resources/jsp/nav-index.jsp"/>
<%--<c:import url="resources/jsp/sidenav-index.jsp"/>--%>
<div class="content" id="content">
    <div class="section no-pad-bot" id="index-banner">
        <div class="container">
            <br><br>
            <h1 class="header center">Learn Fast: Java Web
                Application</h1>
            <div class="row center">
                <h5 class="header col s12 light">A modern social connection and
                    learning management system for mentors and mentees</h5>
            </div>
            <div class="row center">
                <a href="signup.jsp"
                   id="download-button"
                   class="btn-large materialize-red lighten-2">Create an
                    account</a>
            </div>
            <br><br>

        </div>
    </div>


    <div class="container">
        <div class="section">

            <!--   Icon Section   -->
            <div class="row">

                <div class="col s12 m4">
                    <div class="icon-block">
                        <h2 class="center materialize-red-text"><i class="material-icons">
                            flash_on</i></h2>

                        <div class="center">
                            <h5 class="center">Speeds up learning</h5>
                            <img class="center" src="<c:url value="resources/img/bear1-index.jpg"/>" width="150">
                        </div>
                    </div>
                </div>

                <div class="col s12 m4">
                    <div class="icon-block">
                        <h2 class="center materialize-red-text"><i class="material-icons">
                            group</i></h2>

                        <div class="center">
                            <h5 class="center">Experience Focused</h5>
                            <img class="center" src="<c:url value="resources/img/bear2-index.jpg"/>" width="150">
                        </div>
                    </div>
                </div>

                <div class="col s12 m4">
                    <div class="icon-block">
                        <h2 class="center materialize-red-text"><i class="material-icons">
                            settings</i></h2>
                        <div class="center">
                            <h5 class="center">Easy to use</h5>
                            <img class="center" src="<c:url value="resources/img/bear3-index.jpg"/>" width="150">
                        </div>
                    </div>
                </div>

            </div>
            <br><br>
        </div>
    </div>
</div>
<c:import url="resources/jsp/footer-index.jsp"/>
<c:import url="resources/jsp/js.jsp"/>

</body>
</html>
