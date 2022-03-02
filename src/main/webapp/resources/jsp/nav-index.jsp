<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Author: Justin Hoang
Date: 2022-Feb-28-Mon
Time: 6:21 PM
--%>

<nav class="materialize-red lighten-2" id="nav" role="navigation">
    <div class="nav-wrapper container" id="nav">


        <ul class="right hide-on-med-and-down">
            <li><a class="materialize-red white-text btn" href="<c:url value="/signup.jsp"/>">Create an account</a></li>
        </ul>
        <ul class="right hide-on-small-and-down hide-on-med-and-up">
            <li><a class="materialize-red white-text btn" href="<c:url value="/signup.jsp"/>">Get Learn Fast</a></li>
        </ul>

        <ul class="left show-on-small">
            <li><a id="logo-container" href="#" class="left brand-logo show-on-small">Learn Fast</a></li>
        </ul>
        <ul class="right show-on-small">
            <li><a class="white materialize-red-text btn" href="<c:url value="/signin.jsp"/>">Sign in</a>
            </li>
        </ul>
        <%--        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>--%>
    </div>
</nav>


<%--<nav class="light-blue lighten-1" role="navigation">--%>
<%--    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">Logo</a>--%>
<%--        <ul class="right hide-on-med-and-down">--%>
<%--            <li><a href="#">Navbar Link</a></li>--%>
<%--        </ul>--%>

<%--        <ul id="nav-mobile" class="sidenav">--%>
<%--            <li><a href="#">Navbar Link</a></li>--%>
<%--        </ul>--%>
<%--        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>--%>
<%--    </div>--%>
<%--</nav>--%>