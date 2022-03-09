<%--
Author: Justin Hoang
Date: 2022-Mar-06-Sun
Time: 7:25 PM
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "contextPath" value = "${pageContext.request.contextPath}"/>
<c:import url = "resources/jsp/content-type.jsp"/>
<head>
    <c:import url = "resources/jsp/meta.jsp"/>
    <title>Learn Fast: Free, Private & Secure Community</title>
    <c:import url = "resources/jsp/css.jsp"/>
</head>
<body>
<c:import url = "resources/jsp/nav.jsp"/>
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
                             src = "<c:url value="resources/img/bear1-welcome.jpg"/>"
                             width = "150">
                    </div>
                </div>

                <div class = "col s12 m4">
                    <div class = "center">
                        <img class = "center"
                             src = "<c:url value="resources/img/bear2-welcome.jpg"/>"
                             width = "150">
                    </div>
                </div>

                <div class = "col s12 m4">
                    <div class = "center">
                        <img class = "center"
                             src = "<c:url value="resources/img/bear3-welcome.jpg"/>"
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
                        <h2 class = "center brown-text"><i
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
                        <h2 class = "center brown-text"><i
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
                        <h2 class = "center brown-text"><i
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


</div>
</div>

<c:import url = "resources/jsp/js.jsp"/>
<!-- Always visible Sticky Bottom Nav-->
<div class = "nav-bottom stickyBottom" id = "stickyBottom">
    <c:import url = "resources/jsp/nav-bottom.jsp"/>
</div>

<!-- Only visible when your at the bottom of the page-->
<div class = "footer">
    <c:import url = "resources/jsp/footer.jsp"/>
</div>
</body>

</html>
