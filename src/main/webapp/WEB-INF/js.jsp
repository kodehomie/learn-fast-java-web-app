<%--JAVASCRIPT--%>
<script type = "text/javascript"
        src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type = "text/javascript"
        src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<%--FRAMEWORK--%>
<script type = "text/javascript"
        src = "js/jquery-3.6.0.min.js"></script>
<script type = "text/javascript"
        src = "js/materialize.js"></script>
<script type = "text/javascript"
        src = "plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<%--TEMPLATE--%>
<script type = "text/javascript" src = "js/init.js"></script>
<script type = "text/javascript" src = "js/settings.js"></script>
<%--    <script type = "text/javascript" src = "resources/js/scripts.js"></script>--%>
<%--DATATABLES--%>
<script type = "text/javascript"
        src = "js/jquery.dataTables.min.js"></script>
<script type = "text/javascript"
        src = "js/dataTables.material.min.js"></script>
<script type = "text/javascript"
        src = "https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTable').DataTable({
            "scrollY": 500,
            "scrollX": true,
            "paging": true
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