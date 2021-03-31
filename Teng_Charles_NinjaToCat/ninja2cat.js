$(document).ready(function(){
    $("img").on("click", function(){
        var main = $(this).attr("src");
        var alt = $(this).attr("data-alt-src");
        $(this).attr("src", alt);
        $(this).attr("data-alt-src", main);
    })
})