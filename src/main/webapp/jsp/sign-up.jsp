<%--
  Created by IntelliJ IDEA.
  User: justinhoang
  Date: 2/13/22
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="contentType.jsp"/>
<html>
<jsp:include page="head.jsp"/>
<jsp:include page="js.jsp"/>
<body role="document">
<jsp:include page="nav.jsp"/>

<div class="row">
    <form class="col s12">
        <div class="row">
            <div class="input-field col s6">
                <input placeholder="Placeholder" id="first_name" type="text" class="validate">
                <label for="first_name">First Name</label>
            </div>
            <div class="input-field col s6">
                <input id="last_name" type="text" class="validate">
                <label for="last_name">Last Name</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="username" type="username" class="validate">
                <label for="username">Username</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="email" type="email" class="validate">
                <label for="email">Email</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="password" type="password" class="validate">
                <label for="password">Password</label>
            </div>
        </div>

        <div class="row">
            <div class="col s12">
                This is an inline input field:
                <div class="input-field inline">
                    <input id="email_inline" type="email" class="validate">
                    <label for="email_inline">Email</label>
                    <span class="helper-text" data-error="wrong" data-success="right">Helper text</span>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
<jsp:include page="footer.jsp"/>
</html>
