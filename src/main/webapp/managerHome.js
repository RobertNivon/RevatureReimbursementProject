var isShowing = true;
$("#sidebar-toggle").click(function(e) {
    console.log("hello");
    isShowing = !isShowing;
    if (!isShowing) {
        $("#website-content").css({marginLeft: "-18em"});
    }
    else {
        $("#website-content").css({marginLeft: "0"});
    }
    $("#sidebar-container").toggle();
});