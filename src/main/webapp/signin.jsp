<%--
Author: Justin Hoang
Date: 2022-Feb-28-Mon
Time: 6:21 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="resources/jsp/content-type.jsp"/>
<head>
    <c:import url="resources/jsp/meta.jsp"/>
    <title>Learn Fast</title>
    <c:import url="resources/jsp/css.jsp"/>
</head>
<body>

<div class="section no-pad-bot" id="index-banner">
    <div class="container">
        <br><br>

        <div class="container">

            <form method="POST" action="signin" class="form-login">
                <h2 class="form-heading">Sign in</h2>
                <h5 class="form-heading col s12 light">to continue to Learn Fast</h5>

                <div class="form-group ${error != null ? 'has-error' : ''}">

                    <div class="input-field col s6">
                        <i class="material-icons prefix">account_circle</i>
                        <input placeholder="Username" id="username" name="username" type="text" class="validate"
                               autofocus="true">
                        <label for="username"></label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">lock</i>
                        <input placeholder="Password" id="password" name="password" type="text" class="validate"
                               autofocus="true">
                        <label for="password"></label>
                    </div>

                    <a class="left materialize-red-text" href="signup.jsp">Create account</a>
                    <button class="right btn btn-lg btn-primary btn-block materialize-red" type="submit" value="signin">
                        Next
                    </button>
                </div>

            </form>

        </div>
    </div>
</div>


<c:import url="resources/jsp/js.jsp"/>

</body>
</html>