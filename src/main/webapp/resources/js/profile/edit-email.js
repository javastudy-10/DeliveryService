/**
 * Created by Maxim Sambulat
 */
function isValidEmailAddress(email) {
    var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{1,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
    return pattern.test(email);
}

function checkEmail(){
    var email = $("input#newEmail").val();

    if(email != 0)
    {
        if(isValidEmailAddress(email))
        {
            $('#imageValidEmail').removeClass('glyphicon-remove').addClass('glyphicon-ok').css({"color" : "green"});
            $("#labelNewEmail").css({ "color": "black" });

        } else {
            $("#imageValidEmail").removeClass("glyphicon-ok").addClass("glyphicon-remove").css({"color" : "red"});
            $("#labelNewEmail").css({ "color": "red" });
        }
    } else {
        $("#imageValidEmail").removeClass("glyphicon-ok").removeClass("glyphicon-remove").css({"color" : ""});
        $("#labelNewEmail").css({ "color": "black" });
    }
};

function checkSubmit() {
    var email = $("input#newEmail").val();
    var password = $("input#password").val();

    if(email == 0 || !isValidEmailAddress(email)) {
        $("#title-error").text(msg_email_error);
        $("#fix-error").text(msg_email_fix);
        $("#dialog-message").dialog("open");
        return false;
    }

    if(password == 0 || !isValidPassword(password)) {
        $("#title-error").text(msg_password_error);
        $("#fix-error").text(msg_password_fix);
        $("#dialog-message").dialog("open");
        return false;
    }

    return true;
}