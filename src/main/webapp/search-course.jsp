<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "contextPath" value = "${pageContext.request.contextPath}"/>
<c:import url = "resources/jsp/content-type.jsp"/>
<c:set var = "title" value = "Search Courses"/>
<head>
    <c:import url = "resources/jsp/meta.jsp"/>
    <title>${title}</title>
    <c:import url = "resources/jsp/css.jsp"/>
</head>
<body>

<div class = "section no-pad-bot" id = "index-banner">
    <div class = "container">
        <br><br>
        <h1 class = "header center">Courses</h1>
        <div class = "row center">
            <h5 class = "header col s12 light"></h5>
        </div>

        <div class = "centered highlight">
            <h2></h2>
            <form action = "searchCourse">
                <p>
                    <label>
                        <input class = "with-gap" name = "searchTerm"
                               type = "text" id = "searchTerm"/>
                        <span>Search Term</span>
                    </label>
                </p>
                <br>
                <p>
                    <label>
                        <input class = "with-gap" name = "searchType"
                               type = "radio" id = "id" value = "id"/>
                        <span>ID</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input class = "with-gap" name = "searchType"
                               type = "radio" id = "title" value = "title"/>
                        <span>Title</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input class = "with-gap" name = "searchType"
                               type = "radio" id = "section" value = "section"/>
                        <span>Section</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input class = "with-gap" name = "searchType"
                               type = "radio" id = "format"
                               value = "format"/>
                        <span>Section Status</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input class = "with-gap" name = "searchType"
                               type = "radio" id = "mentor"
                               value = "mentor"/>
                        <span>Section Status</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input class = "with-gap" name = "searchType"
                               type = "radio" id = "sectionStatus"
                               value = "sectionStatus"/>
                        <span>Section Status</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input class = "with-gap" name = "searchType"
                               type = "radio" id = "meets" value = "meets"/>
                        <span>Meets</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input class = "with-gap" name = "searchType"
                               type = "radio" id = "dates" value = "dates"/>
                        <span>Dates</span>
                    </label>
                </p>

                <p>
                    <label>
                        <button type = "submit" name = "submit" id = "submit"
                                value = "search"
                                class = "materialize-red lighten-2
                        btn-large">Next
                        </button>
                        <span></span>
                    </label>
                </p>
            </form>
        </div>
    </div>
    <br><br>

</div>

<c:import url = "resources/jsp/js.jsp"/>
<!-- Always visible Sticky Bottom Nav-->
<div class = "nav-bottom stickyBottom" id = "stickyBottom">
    <c:import url = "resources/jsp/nav-bottom.jsp"/>
</div>

<!-- Only visible when your at the bottom of the page-->
<%--<div class = "footer">--%>
<%--    <c:import url = "resources/jsp/footer.jsp"/>--%>
<%--</div>--%>

</body>

</html>