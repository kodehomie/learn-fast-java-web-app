<%--PRELOADER--%>
<div class = "preloader-background">
    <div class = "preloader-wrapper">
        <div id = "preloader"></div>
    </div>
</div>

<nav class = "fixedtop topbar navigation primary" role = "navigation">
    <div class = "nav-wrapper">
        <a id = "logo-container"
           href = "${pageContext.request.contextPath}/welcome"
           class = "brand-logo">Learn Fast</a>
        <ul>
            <li><a href = "#"
                   data-target = " "
                   class = "navicon back-button htmlmode show-on-large ">
                <i class = "mdi mdi-chevron-left"
                   data-page = " "></i></a>
            </li>

            <li><a href = "#"
                   data-target = "slide-nav"
                   class = "navicon sidenav-trigger show-on-large">
                <i class = "mdi mdi-menu"></i></a>
            </li>

        </ul>
    </div>
</nav>

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
                        <i class = "mdi mdi-laptop"></i>
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
                        <span class = "title">Call</span> </a>
                </div>
            </li>

            <li class = "lvl1 ">
                <div class = "waves-effect ">
                    <a href = "sms:+1 234 567 890">
                        <i class = "mdi mdi-message-text-outline"></i>
                        <span class = "title">Text (SMS)</span> </a>
                </div>
            </li>

            <li class = "lvl1 ">
                <div class = "waves-effect ">
                    <a href = "mailto:jhoang1@madisoncollege.edu">
                        <i class = "mdi mdi-email-outline"></i>
                        <span class = "title">Email</span> </a>
                </div>
            </li>

            <li class = "sep-wrap">
                <div class = "divider"></div>
            </li>

            </li>
        </ul>
    </li>

    <li class = "copy-spacer"></li>
    <li class = "copy-wrap">
        <div class = "copyright">&copy; 2022 Justin Hoang, All rights
                                 reserved.
        </div>
</ul>