$(document).ready(function () {

    var baseUrl = $('head base').attr('href');
    $.ajaxSetup({
    beforeSend: function(xhr, options) {
        options.url = baseUrl + options.url;
    }
    })

    //updateTweets();

    $("#js-sendtweet").on("click", function () {
        sendTweet()
    });
});

function sendTweet() {
    $input = $("#js-tweet-text");
    var text = $input.val();
    if (text.length == 0) {
        return;
    }
    $.ajax({
        url: "tweets/add",
        type: "POST",
        data: {
            text: text
        },
        success: function () {
            updateTweets();
        }
    })
}

function updateTweets() {
    //$.ajax({
    //    url: "tweets/pages/1",
    //    type:"GET",
    //    dataType: "html",
    //    success: function(data) {
    //        $("#js-tweets").html(data);
    //    }
    location.reload();
    }