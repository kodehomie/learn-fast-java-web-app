<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: justinhoang
  Date: 2/13/22
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="contentType.jsp" />
<html>
<jsp:include page="head.jsp" />
<body role="document">
<jsp:include page="nav.jsp" />
<body>
<c:choose>
    <c:when test = "${errorMessage == null}">
        <div class="alert alert-success" role="alert">
            <h1>Hi friend,</h1>
            <p>Welcome to Learn Fast. Your new account is ready!</p>
        </div>
    </c:when>
    <c:otherwise>
        <div class="alert alert-danger" role="alert">
            <strong>The account creation failed.</strong><br/>
            ${errorMessage}<br /><br />
                <a href="sign-up.jsp"><button
                        class="btn waves-effect waves-light" type="submit"
                        name="action">Retry
                    <i class="material-icons right">send</i>
                </button>
            </a>
            <a href="" class="waves-effect waves-light btn-large">
                Button</a>Cancel

        </div>
    </c:otherwise>
</c:choose>
</body>
<jsp:include page="footer.jsp"/>
</html>
