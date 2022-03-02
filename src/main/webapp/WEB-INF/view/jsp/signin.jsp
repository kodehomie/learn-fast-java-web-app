<%--
Author: Justin Hoang
Date: 2022-Feb-28-Mon
Time: 6:21 PM
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="../../../resources/jsp/content-type.jsp"/>
<head>
    <c:import url="../../../resources/jsp/meta.jsp"/>
    <title>Sign In</title>
    <c:import url="../../../resources/jsp/css.jsp"/>
</head>
<body>
<c:import url="../../../resources/jsp/nav.jsp"/>

<div class="container">

    <form method="POST" action="${contextPath}/signin" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/signup">Create an account</a></h4>
        </div>

    </form>

</div>
<%--<div class="container">--%>
<%--    <strong>Sign in | <a href="signup.jsp">Create an account</a></strong>--%>
<%--    <form action="/signin" method="post">--%>
<%--        User Id: <input type="text" name="userId"/>--%>
<%--        Password: <input type="password" name="password"/>--%>
<%--        <input type="submit" value="Login"/>--%>
<%--    </form>--%>
<%--</div>--%>
<%--${msg}--%>
<c:import url="../../../resources/jsp/footer.jsp"/>
<c:import url="../../../resources/jsp/js.jsp"/>

</body>
</html>