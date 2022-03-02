<%--
Author: Justin Hoang
Date: 2022-Feb-28-Mon
Time: 6:21 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../../resources/jsp/content-type.jsp"/>
<head>
    <c:import url="../../../resources/jsp/meta.jsp"/>
    <title>Sign Up</title>
    <c:import url="../../../resources/jsp/css.jsp"/>
</head>
<body>

<div class="section no-pad-bot" id="index-banner">
    <div class="container">
        <br><br>
        <h1 class="header center">Create your Learn Fast Account</h1>
        <div class="row center">
            <h5 class="header col s12 light">to continue to Learn Fast</h5>
        </div>
        <div class="row center">
            <form class="col s12">
                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">account_circle</i>
                        <input placeholder="First Name" id="first_name" type="text" class="validate">
                        <label for="first_name"></label>
                    </div>
                    <div class="input-field col s6">
                        <i class="material-icons prefix">account_circle</i>
                        <input placeholder="Last Name" id="last_name" type="text" class="validate">
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">mail</i>
                        <input placeholder="Email" id="email" type="email" class="validate">
                    </div>
                    <div class="input-field col s6">
                        <i class="material-icons prefix">phone</i>
                        <input placeholder="Phone" id="phone" type="text" class="validate">
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">person</i>
                        <input placeholder="Username" id="username" type="text" class="validate">
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">lock</i>
                        <input placeholder="Password" id="password" type="password" class="validate">
                    </div>
                </div>

                <a input type="submit" value="Next" class="materialize-red lighten-2 btn-large">Next</a>


            </form>
        </div>
        <br><br>

    </div>
</div>


<%--<form action="/signup" method="post">--%>
<%--		<pre>--%>
<%--	    <strong>Create an account | <a href="signin.jsp">Sign in</a></strong>--%>
<%--		--%>
<%--		User Id: <input type="text" name="userId"/>--%>
<%--		--%>
<%--		Password: <input type="password" name="password"/>--%>
<%--	--%>
<%--		<input type="submit" value="Next"/>--%>
<%--	</pre>--%>
<%--</form>--%>

<%--${msg}--%>

<c:import url="../../../resources/jsp/js.jsp"/>

</body>
</html>