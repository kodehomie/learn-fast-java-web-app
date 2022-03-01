<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Author: Justin Hoang
Date: 2022-Feb-28-Mon
Time: 6:21 PM
--%>
<nav class="materialize-red lighten-2" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#"
                                          class="brand-logo">Learn Fast</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="<c:url value="/signin.jsp"/>">Sign in</a></li>
            <li><a href="<c:url value="/signup.jsp"/>">Create an account</a></li>
        </ul>

        <ul id="nav-mobile" class="sidenav">
            <li><a href="<c:url value="/signin.jsp"/>">Sign in</a></li>
            <li><a href="<c:url value="/signup.jsp"/>">Create an account</a></li>
        </ul>
        <a href="#" data-target="slide-out" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
</nav>