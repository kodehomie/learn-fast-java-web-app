<%--
Author: Justin Hoang
Date: 2022-Mar-06-Sun
Time: 7:25 PM
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
    <title>Learn Fast: Free, Private & Secure Community</title>
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
    <div class = "nav-wrapper">
        <a id = "logo-container" href = "${pageContext.request.contextPath}/welcome"
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
            <h1 class = "header center">Welcome!</h1>
            <div class = "row center">
                <h5 class = "header col s12 light">:)</h5>
            </div>
            <br><br>

        </div>
    </div>

    <div class = "container">
        <div class = "section">

            <!--   Image Section   -->
            <div class = "row">
                <div class = "col s12 m4">
                    <div class = "center">
                        <img class = "center"
                             src = "resources/img/bear1-welcome.jpg"
                             width = "150">
                    </div>
                </div>

                <div class = "col s12 m4">
                    <div class = "center">
                        <img class = "center"
                             src = "resources/img/bear2-welcome.jpg"
                             width = "150">
                    </div>
                </div>

                <div class = "col s12 m4">
                    <div class = "center">
                        <img class = "center"
                             src = "resources/img/bear3-welcome.jpg"
                             width = "150">
                    </div>
                </div>
            </div>

        </div>
        <br><br>
    </div>

    <div class = "container">
        <div class = "section">

            <!--   Icon Section   -->
            <div class = "row">
                <div class = "col s12 m4">
                    <div class = "icon-block">
                        <h2 class = "center primary-text"><i
                                class = "material-icons">flash_on</i></h2>
                        <h5 class = "center">Learn Fast</h5>

                        <p class = "light">Lorem ipsum dolor sit amet,
                                           consectetur adipiscing elit, sed do
                                           eiusmod tempor incididunt ut labore
                                           et dolore magna aliqua. Sed elementum
                                           tempus egestas sed sed risus pretium
                                           quam vulputate. Nibh nisl condimentum
                                           id venenatis a condimentum vitae
                                           sapien. Aenean euismod elementum nisi
                                           quis eleifend quam adipiscing. Id
                                           ornare arcu odio ut. Nisi scelerisque
                                           eu ultrices vitae auctor eu augue ut
                                           lectus. Sem integer vitae justo eget
                                           magna fermentum. Egestas purus
                                           viverra accumsan in nisl nisi
                                           scelerisque eu. Tellus at urna
                                           condimentum mattis pellentesque.
                                           Vitae aliquet nec ullamcorper sit
                                           amet. Vitae congue mauris rhoncus
                                           aenean vel elit scelerisque mauris
                                           pellentesque. Pretium fusce id velit
                                           ut tortor pretium viverra suspendisse
                                           potenti. Nunc vel risus commodo
                                           viverra maecenas accumsan. Duis ut
                                           diam quam nulla porttitor massa id
                                           neque aliquam. Pellentesque massa
                                           placerat duis ultricies lacus sed
                                           turpis. Habitant morbi tristique
                                           senectus et netus.</p>
                    </div>
                </div>

                <div class = "col s12 m4">
                    <div class = "icon-block">
                        <h2 class = "center primary-text"><i
                                class = "material-icons">group</i></h2>
                        <h5 class = "center">Mentors</h5>

                        <p class = "light">Eget sit amet tellus cras adipiscing
                                           enim eu turpis. Enim nulla aliquet
                                           porttitor lacus luctus accumsan
                                           tortor posuere ac. Ornare suspendisse
                                           sed nisi lacus sed viverra tellus.
                                           Vitae et leo duis ut diam quam nulla
                                           porttitor massa. Tincidunt nunc
                                           pulvinar sapien et ligula ullamcorper
                                           malesuada proin. Eget duis at tellus
                                           at urna condimentum mattis. Nunc vel
                                           risus commodo viverra maecenas.
                                           Turpis egestas integer eget aliquet
                                           nibh praesent tristique magna sit.
                                           Egestas dui id ornare arcu odio ut
                                           sem nulla pharetra. Orci porta non
                                           pulvinar neque. In egestas erat
                                           imperdiet sed euismod nisi porta.
                                           Augue ut lectus arcu bibendum at
                                           varius vel pharetra. Nam libero justo
                                           laoreet sit. Sed viverra tellus in
                                           hac. In cursus turpis massa tincidunt
                                           dui. Vestibulum lorem sed risus
                                           ultricies. Luctus venenatis lectus
                                           magna fringilla.</p>
                    </div>
                </div>

                <div class = "col s12 m4">
                    <div class = "icon-block">
                        <h2 class = "center primary-text"><i
                                class = "material-icons">group</i></h2>
                        <h5 class = "center">Mentees</h5>

                        <p class = "light">Magna ac placerat vestibulum lectus
                                           mauris ultrices eros in cursus.
                                           Auctor eu augue ut lectus arcu
                                           bibendum at varius. Diam in arcu
                                           cursus euismod quis viverra nibh cras
                                           pulvinar. Turpis egestas maecenas
                                           pharetra convallis posuere morbi.
                                           Orci ac auctor augue mauris augue
                                           neque gravida in fermentum. Aliquam
                                           sem et tortor consequat id porta
                                           nibh. Venenatis urna cursus eget nunc
                                           scelerisque viverra mauris in
                                           aliquam. Lobortis scelerisque
                                           fermentum dui faucibus in. Ornare
                                           arcu odio ut sem nulla pharetra diam.
                                           Ac odio tempor orci dapibus ultrices
                                           in iaculis nunc. Et egestas quis
                                           ipsum suspendisse ultrices gravida
                                           dictum fusce. Mattis rhoncus urna
                                           neque viverra justo nec ultrices dui
                                           sapien. Dui accumsan sit amet nulla
                                           facilisi morbi tempus iaculis. At
                                           erat pellentesque adipiscing commodo
                                           elit at imperdiet dui. Fringilla
                                           phasellus faucibus scelerisque
                                           eleifend donec. Egestas fringilla
                                           phasellus faucibus scelerisque
                                           eleifend donec. Ante in nibh mauris
                                           cursus mattis molestie a. Quam
                                           viverra orci sagittis eu volutpat
                                           odio facilisis.</p>
                    </div>
                </div>
            </div>

        </div>
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
                                class = "mdi mdi-phone"></i> +1 234 567 890</a>
                        </li>
                        <li><a class = "" href = "#!"><i
                                class = "mdi mdi-email"></i>
                            justin@gmail.com</a>
                        </li>
                        <li><a class = "" href = "#!"><i
                                class = "mdi mdi-map-marker"></i> 123 Street,
                                                                  Madison, WI,
                                                                  USA</a></li>
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

    <div class = "backtotop">
        <a class = "btn-floating btn primary-bg">
            <i class = "mdi mdi-chevron-up"></i>
        </a>
    </div>


    <div class = "footer-menu">
        <ul>
            <li>
                <a href = "#"> <i class = "mdi mdi-food"></i>
                    <span>X</span>
                </a></li>
            <li>
                <a href = "${pageContext.request.contextPath}/user/usersRead"> <i
                        class = "mdi mdi-account-search"></i>
                    <span>User Listing</span>
                </a></li>
            <li>
                <a href = "${pageContext.request.contextPath}/welcome"> <i
                        class = "mdi mdi-home-outline"></i>
                    <span>Home</span>
                </a></li>
            <li>
                <a href = "#"> <i
                        class = "mdi mdi-music"></i>
                    <span>X</span>
                </a></li>
            <li>
                <a href = "#"> <i
                        class = "mdi mdi-food"></i>
                    <span>X</span>
                </a></li>

        </ul>
    </div>

</div>
<%--JAVASCRIPT--%>
<script type = "text/javascript"
        src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type = "text/javascript"
        src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<%--FRAMEWORK--%>
<script type = "text/javascript"
        src = "resources/js/jquery-3.6.0.min.js"></script>
<script type = "text/javascript" src = "resources/js/materialize.js"></script>
<script type = "text/javascript"
        src = "resources/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<%--TEMPLATE--%>
<script type = "text/javascript" src = "resources/js/init.js"></script>
<script type = "text/javascript" src = "resources/js/settings.js"></script>
<script type = "text/javascript" src = "resources/js/scripts.js"></script>

<script type = "text/javascript">
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
</script>
<script type = "text/javascript">
    document.addEventListener("DOMContentLoaded", function () {
        $('.preloader-background').delay(10).fadeOut('slow');
    });
</script>
<%--JAVASCRIPT END--%>
</body>
</html>