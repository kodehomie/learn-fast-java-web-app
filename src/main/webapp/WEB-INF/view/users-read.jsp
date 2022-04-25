<%--
Author: Justin Hoang
Date: 2022-Mar-21-Mon
Time: 6:09 PM
--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html class = " ">
<head>
    <%--META--%>
    <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
    <meta name = "viewport" content = "width=device-width, initial-scale=1">
    <%--CSS--%>
    <link type = "text/css" rel = "stylesheet"
          href = "resources/css/style.css"
          id = "main-style"
          media = "screen,projection"/>
    <link type = "text/css" rel = "stylesheet"
          href = "resources/css/preloader.css"
          media = "screen,projection"/>
    <link type = "text/css" rel = "stylesheet"
          href = "resources/plugins/perfect-scrollbar/perfect-scrollbar.css"
          media = "screen,projection"/>
    <link type = "text/css" rel = "stylesheet"
          href = "resources/js/dataTables.material.min.js"
          media = "screen,projection"/>
    <%--MATERIAL DESIGN--%>
    <link type = "text/css" rel = "stylesheet"
          href = "resources/fonts/mdi/materialdesignicons.min.css"
          media = "screen,projection"/>
    <link type = "text/css" rel = "stylesheet"
          href = "https://fonts.googleapis.com/icon?family=Material+Icons"
          media = "screen,projection"/>
    <%--ICON--%>
    <link rel = "apple-touch-icon" sizes = "57x57"
          href = "resources/img/icons/57.png">
    <link rel = "apple-touch-icon" sizes = "60x60"
          href = "resources/img/icons/60.png">
    <link rel = "apple-touch-icon" sizes = "72x72"
          href = "resources/img/icons/72.png">
    <link rel = "apple-touch-icon" sizes = "76x76"
          href = "resources/img/icons/76.png">
    <link rel = "apple-touch-icon" sizes = "114x114"
          href = "resources/img/icons/114.png">
    <link rel = "apple-touch-icon" sizes = "120x120"
          href = "resources/img/icons/120.png">
    <link rel = "apple-touch-icon" sizes = "144x144"
          href = "resources/img/icons/144.png">
    <link rel = "apple-touch-icon" sizes = "152x152"
          href = "resources/img/icons/152.png">
    <link rel = "apple-touch-icon" sizes = "180x180"
          href = "resources/img/icons/180.png">
    <link rel = "icon" type = "image/png" sizes = "196x196"
          href = "resources/img/icons/196.png">
    <link rel = "icon" type = "image/png" sizes = "32x32"
          href = "resources/img/icons/favicon-32x32.png">
    <link rel = "icon" type = "image/png" sizes = "100x100"
          href = "resources/img/icons/favicon-100x100.png">
    <link rel = "icon" type = "image/png" sizes = "16x16"
          href = "resources/img/icons/favicon-16x16.png">
    <link rel = "manifest" href = "resources/img/icons/manifest.json">
    <meta name = "msapplication-TileColor" content = "#ffffff">
    <meta name = "msapplication-TileImage"
          content = "resources/images/icons/ms-icon-144x144.png">
    <meta name = "theme-color" content = "#ffffff">
    <%--MATERIALIZE CSS--%>
    <link type = "text/css" rel = "stylesheet"
          href = "https://fonts.googleapis.com/icon?family=Material+Icons">
    <link type = "text/css" rel = "stylesheet"
          href = "resources/css/materialize.css"
          media = "screen,projection"/>
    <link type = "text/css" rel = "stylesheet"
          href = "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"
          media = "screen,projection">
    <%--TITLE--%>
    <title>Learn Fast: User Listing</title>
</head>
<body class = "html" data-header = "colored" data-footer = "light"
      data-header_align = "center" data-menu_type = "left" data-menu = "colored"
      data-menu_icons = "on" data-footer_type = "left" data-site_mode = "light"
      data-footer_menu = "show" data-footer_menu_style = "colored">

<%--PRELOADER--%>
<div class = "preloader-background">
    <div class = "preloader-wrapper">
        <div id = "preloader"></div>
    </div>
</div>

<nav class = "fixedtop topbar navigation primary" role = "navigation">
    <a id = "logo-container" href = "${pageContext.request.contextPath}/welcome"
       class = "brand-logo">Learn Fast</a>

    <a href = "#"
       data-target = " "
       class = "navicon back-button htmlmode show-on-large ">
        <i class = "mdi mdi-chevron-left"
           data-page = " "></i></a>


    <a href = "#"
       data-target = "slide-nav"
       class = "navicon sidenav-trigger show-on-large">
        <i class = "mdi mdi-menu"></i></a>
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

<div class = "content" id = "content">
    <div class = "section no-pad-bot" id = "index-banner">
        <div class = "container">
            <br><br>
            <h1 class = "header center">User Listing</h1>
            <div class = "row center">
                <h5 class = "header col s12 light"></h5>
            </div>
            <br><br>
        </div>
    </div>
</div>

<hr/>

<div class = "container">
    <section class = "section">
        <a href = "userCreateForm" class = "green btn">Create
                                                       User</a>
        <br/><br/>
        <table id = "userTable"
               class = "display nowrap"
               style = "width:100%">
            <thead>
            <tr>
                <th>Username</th>
                <th>Birthdate</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Update || Delete</th>
            </tr>
            </thead>
            <tbody>
            <%--TRAVERSE USERS--%>
            <c:forEach var = "tmpUser"
                       items = "${users}">
                <%--UPDATE--%>
                <c:url var = "updateLink"
                       value = "/user/userUpdateForm">
                    <c:param name = "id"
                             value = "${tmpUser.id}"/>
                </c:url>
                <%--DELETE--%>
                <c:url var = "deleteLink"
                       value = "/user/userDelete">
                    <c:param name = "id"
                             value = "${tmpUser.id}"/>
                </c:url>
                <tr>
                    <td>${tmpUser.username}</td>
                    <td>${tmpUser.birthdate}</td>
                    <td>${tmpUser.givenName}</td>
                    <td>${tmpUser.familyName}</td>
                    <td>${tmpUser.gender}</td>
                    <td>${tmpUser.email}</td>
                    <td>${tmpUser.phoneNumber}</td>
                    <td>
                            <%--UPDATE--%>
                        <a href = "${updateLink}"
                           class = "green btn white-text">Update</a>
                        || <a href = "${deleteLink}"
                              class = "materialize-red btn white-text"
                              onclick = "if (!(confirm('Do you intend to delete user?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</div>


<footer class = "page-footer">
    <div class = "container footer-content">
        <div class = "row">
            <div class = "">
                <h5 class = "logo">Learn Fast</h5>
                <p class = "text">Description</p>
            </div>
            <div class = "link-wrap">
                <ul class = "link-ul">
                    <li><a class = "" href = "#!"><i
                            class = "mdi mdi-phone"></i> +1 234 567
                                                         890</a>
                    </li>
                    <li><a class = "" href = "#!"><i
                            class = "mdi mdi-email"></i>
                        justin@gmail.com</a>
                    </li>
                    <li><a class = "" href = "#!"><i
                            class = "mdi mdi-map-marker"></i> 123
                                                              Street,
                                                              Madison,
                                                              WI,
                                                              USA</a>
                    </li>
                </ul>
                <ul class = "social-wrap">
                    <li class = "social">
                        <a class = "" href = "#!"><i
                                class = "mdi mdi-facebook"></i></a>
                        <a class = "" href = "#!"><i
                                class = "mdi mdi-twitter"></i></a>
                        <a class = "" href = "#!"><i
                                class = "mdi mdi-dribbble"></i></a>
                        <a class = "" href = "#!"><i
                                class = "mdi mdi-google-plus"></i></a>
                        <a class = "" href = "#!"><i
                                class = "mdi mdi-linkedin"></i></a>

                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class = "footer-copyright">
        <div class = "container">
            Built with ❤️ & 🍜 by: Justin Hoang
        </div>
    </div>

</footer>

<%--<div class = "backtotop">--%>
<%--    <a class = "btn-floating btn primary-bg">--%>
<%--        <i class = "mdi mdi-chevron-up"></i>--%>
<%--    </a>--%>
<%--</div>--%>

<%--<div class = "footer-menu">--%>
<%--    <ul>--%>
<%--        <li>--%>
<%--            <a href = "#"> <i class = "mdi mdi-food"></i>--%>
<%--                <span>X</span>--%>
<%--            </a></li>--%>
<%--        <li>--%>
<%--            <a href = "${pageContext.request.contextPath}/user/usersRead">--%>
<%--                <i--%>
<%--                        class = "mdi mdi-account-search"></i>--%>
<%--                <span>User Listing</span>--%>
<%--            </a></li>--%>
<%--        <li>--%>
<%--            <a href = "${pageContext.request.contextPath}/welcome">--%>
<%--                <i--%>
<%--                        class = "mdi mdi-home-outline"></i>--%>
<%--                <span>Home</span>--%>
<%--            </a></li>--%>
<%--        <li>--%>
<%--            <a href = "#"> <i--%>
<%--                    class = "mdi mdi-music"></i>--%>
<%--                <span>X</span>--%>
<%--            </a></li>--%>
<%--        <li>--%>
<%--            <a href = "#"> <i--%>
<%--                    class = "mdi mdi-food"></i>--%>
<%--                <span>X</span>--%>
<%--            </a></li>--%>

<%--    </ul>--%>
<%--</div>--%>


<%--JAVASCRIPT--%>
<script type = "text/javascript"
        src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type = "text/javascript"
        src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<%--FRAMEWORK--%>
<script type = "text/javascript"
        src = "resources/js/jquery-3.6.0.min.js"></script>
<script type = "text/javascript"
        src = "resources/js/materialize.js"></script>
<script type = "text/javascript"
        src = "resources/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<%--TEMPLATE--%>
<script type = "text/javascript" src = "resources/js/init.js"></script>
<script type = "text/javascript" src = "resources/js/settings.js"></script>
<%--    <script type = "text/javascript" src = "resources/js/scripts.js"></script>--%>
<%--DATATABLES--%>
<script type = "text/javascript"
        src = "resources/js/jquery.dataTables.min.js"></script>
<script type = "text/javascript"
        src = "resources/js/dataTables.material.min.js"></script>
<script type = "text/javascript"
        src = "https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#userTable').DataTable({
            "scrollY": 500,
            "scrollX": true
        });
    });

    if ("serviceWorker" in navigator) {
        if (navigator.serviceWorker.controller) {
            console.log("[PWA Builder] active service worker found, no need to register");
        } else {
            navigator.serviceWorker
                .register("pwabuilder-sw.js", {
                    scope: "./"
                })
                .then(function (reg) {
                    console.log("[PWA Builder] Service worker has been registered for scope: " + reg.scope);
                });
        }
    }
    document.addEventListener("DOMContentLoaded", function () {
        $('.preloader-background').delay(10).fadeOut('slow');
    });
</script>
<%--JAVASCRIPT END--%>
</body>
</html>
