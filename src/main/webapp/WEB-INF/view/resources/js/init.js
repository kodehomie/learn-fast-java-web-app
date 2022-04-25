$(document).ready(function () {

    if ($('.sidemenu').length) {
        $('.sidemenu').sidenav({
            onOpenStart: function () {
                $('.sidesettings').sidenav('close');
            }
        });

        const ps1 = new PerfectScrollbar('.sidemenu', {
            suppressScrollX: true
        });
    }

    if ($('.sidesettings').length) {
        $('.sidesettings').sidenav(
            {
                onOpenStart: function () {
                    $('.sidemenu').sidenav('close');
                    //console.log("onopen");
                },
                edge: 'right',

            });

        const ps2 = new PerfectScrollbar('.sidesettings', {
            suppressScrollX: true
        });

    }

    /********************AJAX BASED SITE - START*******************/

    let indexpage = "home";

    if ($("body").hasClass("ajaxurl")) {
        let indexpage = $("body").attr("data-app-page");
        if (indexpage == "index") {
            indexpage = "home";
        }
        ajaxload_script(indexpage, "");
    }

    if ($("body").hasClass("ajax")) {
        ajaxload_script(indexpage, "");
    }

    $(document).on('click', '.ajaxmode', function (e) {
        e.preventDefault();
        $("body").addClass("ajaxloading");
        //console.log("clicked");

        $("body").removeClass("isfullscreen");
        let screenattr = $(this).attr("data-screen");
        if (screenattr == "full") {
            $("body").addClass("isfullscreen");
        }

        $('.sidemenu').sidenav('close');
        $('.sidesettings').sidenav('close');
        $("HTML, BODY").animate({scrollTop: 0}, 400, 'swing');

        let page = $(this).attr("data-page");

        $.when($('.preloader-background').show()).done(function () {
            $('.sidemenu').sidenav('close');
            $('.sidesettings').sidenav('close');
        });

        ajaxload_script(page, "");
    });


    if ($("body").hasClass("ajaxurl") || $("body").hasClass("ajax")) {

        window.addEventListener('popstate', function (e) {
            let poppage = e.state;
            if (poppage == null) {
                poppage = "home";
            }

            ajaxload_script(poppage, "pop");
        });
    }

    function ajaxload_script(page, calltype) {
        let sitemode = "html";
        if ($("body").hasClass("ajax")) {
            sitemode = "ajax";
        } else if ($("body").hasClass("ajaxurl")) {
            sitemode = "ajaxurl";
        }
        let data = {
            sitemode: sitemode,
            page: page,
        };

        let pagefile = page + ".php";

        $.ajax({
            data: data,
            type: 'POST',
            url: pagefile,
            success: function (result) {
                if (sitemode === "ajax") {
                    $("#response_wrapper").html(result);
                } else if (sitemode === "ajaxurl") {
                    // console.log(result);
                    let main = $(result).wrap('<p>').parent().find('main').html();
                    //  console.log("main : " + main);
                    //   return false;
                    $("main").html(main);
                }

            },
            complete: function (data) {
                $('.preloader-background').delay(700).fadeOut('slow');
                $("body").removeClass("ajaxloading");

                if (calltype != "pop") {
                    //console.log("push");
                    let pageurl = page;
                    if (page === "home") {
                        pageurl = "index";
                    }
                    pageurl = pageurl + ".php";
                    window.history.pushState(page, null, pageurl);
                }

                if (page != "home") {
                    $("body").removeClass("ishome");
                } else {
                    $("body").addClass("ishome");
                }
                return false;
            }
        });
    }
});

/********************AJAX BASED SITE - END*******************/

$(document).ready(function () {

    $(document).on('click', '.back-button', function (e) {
        e.preventDefault();
        $('.sidemenu').sidenav('close');
        $('.sidesettings').sidenav('close');
        window.history.back();
    });

    $(document).on('click', '.menu-close', function (e) {
        $('.sidemenu').sidenav('close');
    });

});

/********************Equal Height*******************/

$(document).ready(function () {

    $('.equal-height').each(function () {

        let highestBox = 0;

        $('.col', this).each(function () {

            if ($(this).height() > highestBox) {
                highestBox = $(this).height();
            }

        });

        $('.col', this).height(highestBox);
    });
});

function fixNavbar() {
    let $totop = $('.backtotop'),
        $nav = $('nav.fixedtop'),
        totop = 200,
        offset = 0,
        logoHeight = 56,
        distance = offset + logoHeight,
        scroll = $(window).scrollTop();

    if (scroll >= distance) {
        $nav.css({
            'position': 'fixed',
            'top': '0',
            'right': '0',
            'left': '0'
        });
    } else {
        $nav.css({
            'position': 'relative',
            'top': 'auto',
            'right': 'auto',
            'left': 'auto'
        });
    }

    if (scroll >= totop) {
        $totop.css({
            'display': 'inline-block',
        });
    } else {
        $totop.css({
            'display': 'none',
        });
    }
}

function fixNavbar_backup() {

    $(window).bind('mousewheel DOMMouseScroll onmousewheel touchmove scroll', function (event) {
        if (event.originalEvent.wheelDelta >= 0) {
            //console.log('Scroll up');
            $("body").addClass("fixedtopbar");
        } else {
            // console.log('Scroll down');
            $("body").removeClass("fixedtopbar");
        }
    });

    let $totop = $('.backtotop'),
        $nav = $('nav.fixedtop'),
        totop = 200,
        offset = 0,
        logoHeight = 56,
        distance = offset + logoHeight,
        scroll = $(window).scrollTop();

    if (scroll >= totop) {
        $totop.css({
            'display': 'inline-block',
        });
    } else {
        $totop.css({
            'display': 'none',
        });
    }
}

$(document).ready(function () {
    $(document).on('click', '.backtotop', function (e) {
        $("HTML, BODY").animate({scrollTop: 0}, 400, 'swing');
    });
});

$(window).scroll(function () {
    fixNavbar();
});