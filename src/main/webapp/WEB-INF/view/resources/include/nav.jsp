<%--
Author: Justin Hoang
Date: 2022-Mar-24-Thu
Time: 3:48 PM
--%>
<script type = "text/javascript">
    function getPageNameFromURL() {
        let URL = document.location.href;
        let PageName = URL.substring(URL.lastIndexOf('/') + 1);
        return PageName;
    }

    $(document).ready(function () {
        let PageName = getPageNameFromURL();

        switch (PageName) {
            case 'userCreateForm':
                $('#userCreateForm').addClass("active");
                break;
            case 'usersRead':
                $('#usersRead').addClass("active");
                break;
            case 'userUpdateForm?id=':
                $('#userUpdateForm').addClass("active");
                break;
            case 'userDelete?id=':
                $('#userDelete').addClass("active");
                break;
            case 'welcome':
                $('#index').addClass("active");
                break;
            default:
                $('#logo-container').addClass("active");
                break;
        }
    });
</script>

<nav class = "materialize-red lighten-2" role = "navigation">
    <div class = "nav-wrapper container left show-on-small"><a
            id = "logo-container" href = "welcome"
            class = "left brand-logo show-on-small">LearnFast</a>

        <ul class = "right hide-on-med-and-down">
            <li><a href = "#">Navbar Link</a></li>
        </ul>

        <ul id = "nav-mobile" class = "sidenav">
            <li><a href = "#">Navbar Link</a></li>
        </ul>
        <a href = "#" data-target = "nav-mobile" class = "sidenav-trigger"><i
                class = "material-icons">menu</i></a>

    </div>
</nav>