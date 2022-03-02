<%--
Author: Justin Hoang
Date: 2022-Feb-28-Mon
Time: 6:21 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="resources/content-type.jsp"/>
<head>
    <c:import url="resources/meta.jsp"/>
    <title>Learn Fast - Sign Up</title>
    <c:import url="resources/css.jsp"/>
</head>
<body>

<div class="container">
    <br><br>


    <div class="container">
        <br><br>

        <div class="row center">
            <form method="POST" action="signup" class="form">
                <h2 class="form-heading">Create your Lean Fast Account</h2>
                <h5 class="form-heading col s12 light">to continue to Learn Fast</h5>

                <div class="form-group ${error != null ? 'has-error' : ''}">

                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">account_circle</i>
                            <input placeholder="birthdate" id="birthdate" type="date" class="validate">
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6">
                            <i class="material-icons prefix">account_circle</i>
                            <input placeholder="First Name" id="first_name" type="text" class="validate">
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

                    <button class="right btn btn-lg btn-primary btn-block materialize-red" type="submit"
                            value="signup">
                        Next
                    </button>
                </div>

            </form>

        </div>
    </div>
</div>


<%--${msg}--%>

<c:import url="resources/js.jsp"/>

</body>
</html>