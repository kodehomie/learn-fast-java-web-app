<%--
Author: Justin Hoang
Date: 2022-Feb-28-Mon
Time: 6:21 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="resources/content-type.jsp"/>
<head>
    <c:import url="resources/meta.jsp"/>
    <title>Learn Fast</title>
    <c:import url="resources/css.jsp"/>
</head>
<body>

<div class="section no-pad-bot" id="index-banner">
    <div class="container">
        <br><br>

        <div class="container">

            <form method="POST" action="/signin" class="form-signin">
                <h2 class="form-heading">Sign in</h2>
                <h5 class="form-heading col s12 light">to continue to Learn Fast</h5>

                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <%--            <span>${message}</span>--%>
                    <div class="input-field col s6">
                        <i class="material-icons prefix">account_circle</i>
                        <input placeholder="Username" id="username" type="text" class="validate"
                               autofocus="true">
                        <label for="username"></label>
                    </div>
                    <div class="input-field col s6">
                        <i class="material-icons prefix">lock</i>
                        <input placeholder="Password" id="password" type="text" class="validate"
                               autofocus="true">
                        <label for="password"></label>
                    </div>

                    <%--            <span>${error}</span>--%>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <a class="left materialize-red-text" href="signup.jsp">Create account</a>
                    <button class="right btn btn-lg btn-primary btn-block materialize-red" type="submit">Next</button>
                </div>

            </form>

        </div>
    </div>
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

<c:import url="resources/js.jsp"/>

</body>
</html>