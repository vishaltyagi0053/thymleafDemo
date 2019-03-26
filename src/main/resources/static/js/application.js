$(document).ready(function () {
    click();
});

var populateUsers = function () {
    var users = $.ajax({
        url: "/list",
        method: "GET"
    });
    users.done(function (data) {
        if (data) {
            $("#user").html(data);
        }
    });
    users.fail(function (jqXHR, textStatus) {
        console.log("Error in fetching users");
    })
};

var click = function () {
    $("#button").click(function () {
        populateUsers();
    });

};