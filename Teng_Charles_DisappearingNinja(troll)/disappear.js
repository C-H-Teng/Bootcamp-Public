$(document).ready(function(){
    $(".imgContainer img").on("click", function(){
        $(this).fadeOut(1500);
    })

    $("button").on("click",function(){
        $("img").show();
    })
})