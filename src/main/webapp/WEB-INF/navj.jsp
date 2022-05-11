<%--TOP NAV--%>
<div class = "fixed-header">
    <div class = "containerx">
        <nav class = "materialize-red lighten-2" id = "nav"
             role = "navigation">
            <div class = "navbar-fixed">

                <ul class = "left show-on-small">
                    <li><a id = "logo-container"
                           href = "${pageContext.request.contextPath}/welcome"
                           class = "left brand-logo show-on-small">Learn
                                                                   Fast</a></li>
                </ul>
                <ul id = "nav-mobile" class = "right hide-on-small-only">
                    <li>
                        <a href = "${pageContext.request.contextPath}/welcome">Home</a>
                    </li>
                    <li>
                        <a href = "${pageContext.request.contextPath}/user/usersRead">User
                                                                                      Listing</a>
                    </li>
                    <li>
                        <a href = "${pageContext.request.contextPath}/course/coursesRead">Course
                                                                                          Listing</a>
                    </li>
                    <li>
                        <a href = "${pageContext.request.contextPath}/activity-generator">Activity Generator</a>
                    </li>
                    <li>
                        <a href = "${pageContext.request.contextPath}/programming-quotes">Programming Quotes</a>
                    </li>
                </ul>

            </div>
        </nav>
    </div>
</div>
<%--TOP NAV END--%>

<ul id = "slide-nav" class = "sidenav sidemenu">
    <li class = "menu-close"><i class = "mdi mdi-equal-box"></i></li>
    <li class = "menulinks">
        <ul class = "collapsible">

            <li class = "sh-wrap">
                <div class = "subheader">Navigation</div>
            </li>

            <li class = "lvl1 ">
                <div class = " waves-effect ">
                    <a href = "${pageContext.request.contextPath}/welcome">
                        <i class = "mdi mdi-home-outline"></i>
                        <span class = "title">Home</span>
                    </a>
                </div>
            </li>

            <li class = "lvl1 ">
                <div class = " waves-effect ">
                    <a href = "${pageContext.request.contextPath}/user/usersRead">
                        <i class = "mdi mdi-account-search"></i>
                        <span class = "title">User Listing</span>
                    </a>
                </div>
            </li>

            <li class = "lvl1 ">
                <div class = " waves-effect ">
                    <a href = "${pageContext.request.contextPath}/course/coursesRead">
                        <i class = "mdi mdi-school"></i>
                        <span class = "title">Course Listing</span>
                    </a>
                </div>
            </li>

            <li class = "lvl1 ">
                <div class = " waves-effect ">
                    <a href = "${pageContext.request.contextPath}/activity-generator">
                        <i class = "mdi mdi-account-group"></i>
                        <span class = "title">Activity Generator</span>
                    </a>
                </div>
            </li>

            <li class = "lvl1 ">
                <div class = " waves-effect ">
                    <a href = "${pageContext.request.contextPath}/programming-quotes">
                        <i class = "mdi mdi-account-group"></i>
                        <span class = "title">Programming Quotes</span>
                    </a>
                </div>
            </li>

            <li class = "sep-wrap">
                <div class = "divider"></div>
            </li>
            <li class = "sh-wrap">
                <div class = "subheader">Contact</div>
            </li>

            <li class = "lvl1 ">
                <div class = "waves-effect ">
                    <a href = "tel:+1 234 567 890">
                        <i class = "mdi mdi-cellphone-basic"></i>
                        <span class = "title">Phone</span> </a>
                </div>
            </li>

            <li class = "lvl1 ">
                <div class = "waves-effect ">
                    <a href = "mailto:jhoang1@madisoncollege.edu">
                        <i class = "mdi mdi-email-outline"></i>
                        <span class = "title">Email</span> </a>
                </div>
            </li>

            <li class = "lvl1 ">
                <div class = "waves-effect ">
                    <a href = "sms:+1 234 567 890">
                        <i class = "mdi mdi-message-text-outline"></i>
                        <span class = "title">Message</span> </a>
                </div>
            </li>

            <li class = "sep-wrap">
                <div class = "divider"></div>
            </li>

            <li class = "lvl1 ">
                <div class = "waves-effect "><a href = "#"
                                                data-target = "slide-settings"
                                                class = "sidenav-trigger"><i
                        class = "mdi mdi-settings-outline"></i><span
                        class = "title">Settings</span> </a>
                </div>
            </li>

            </li>
        </ul>
    </li>
    <li class = "copy-spacer"></li>
    <li class = "copy-wrap">
        <div class = "copyright">&copy; Copyright @ JustinHoang</div>
</ul>