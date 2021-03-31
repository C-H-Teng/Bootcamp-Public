$(document).ready(function(){
    $(".fadeTog button").on("click",function(){
        $("h1").fadeToggle(2000);
    });

    $(".slideTog button").click(function(){
        $("h1").slideToggle("slow");
    });

    $(".fadeOut button").click(function(){
        $("h2").fadeOut(1500);
    })

    $(".fadeIn button").click(function(){
        $("h2").fadeIn(1500);
    })

    $(".overwrite button").click(function(){
        $(".overwrite h2").html("How could you? :(");
    })

    $(".addClass button").click(function(){
        $("#header").addClass("shadow");
    })

    $(".append button").click(function(){
        $(".funContainer .append").append("<h4>something</h4>");
    })

    $("#textSubmit").on("click", function(){
        var input = $("#input").val();
        $(".val").append($("#input").val());
    })

    $(".text button").click(function(){
        $(".text p").text("What did the text ever do to you?");
    })

    $(".attr button").click(function(){
        $(".funContainer img").attr({
            src: "./trollface.png",
            alt: "Troll Face"});
    })

    $(".after button").click(function(){
        $(".after p").after("<h4>Surprise!</h4>")
    })

    $(".before button").click(function(){
        $(".before p").before("<h4>No cutting!</h4>")
    })
})