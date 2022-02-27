<c:import url="context-type.jsp"/>
<c:import url="head.jsp"/>
<body>

<div class="container">

    <form action="signup" method="POST">


        <div class="row form-group">
            <div class="col-md-6 mb-3 mb-md-0">
                <label class="text-black" for="first_name">First Name</label>
                <input type="text" id="first_name" name="first_name" class="form-control" required>
            </div>
            <div class="col-md-6">
                <label class="text-black" for="last_name">Last Name</label>
                <input type="text" id="last_name" name="last_name" class="form-control" required>
            </div>
        </div>

        <div class="row form-group">

            <div class="col-md-12">
                <label class="text-black" for="email">Email</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>
        </div>

        <div class="row form-group">

            <div class="col-md-12">
                <label class="text-black" for="username">Username</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
        </div>

        <div class="row form-group">

            <div class="col-md-12">
                <label class="text-black" for="password">Password</label>
                <input type="text" id="password" name="password" class="form-control" required>
            </div>
        </div>

        <div class="row form-group">
            <div class="col-md-12">
                <input type="submit" name="submit" value="SignUp" class="btn-large materialize-red">
            </div>
        </div>


    </form>

</div>

<jsp:include page="footer.jsp"/>

</body>
</html>