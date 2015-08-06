/**
 * Created by Maxim Sambulat
 */
function checkConfirmPassword(){
    var new_password = $("input#newPassword").val();
    var confirm_password = $("input#confirmPassword").val();

    if(confirm_password != 0)
    {
        if(new_password != 0) {
            if(confirm_password == new_password)
            {
                $('#imageConfirmPassword').removeClass('glyphicon-remove').addClass('glyphicon-ok').css({"color" : "green"});;
                $("#labelConfirmPassword").css({ "color": "black" });
            } else {
                $("#imageConfirmPassword").removeClass("glyphicon-ok").addClass("glyphicon-remove").css({"color" : "red"});;
                $("#labelConfirmPassword").css({ "color": "red" });
            }
        } else {
            $("#imageConfirmPassword").removeClass("glyphicon-ok").addClass("glyphicon-remove").css({"color" : "red"});;
            $("#labelConfirmPassword").css({ "color": "red" });
        }

    } else {
        if(new_password != 0) {
            $("#imageConfirmPassword").removeClass("glyphicon-ok").addClass("glyphicon-remove").css({"color" : "red"});;
            $("#labelConfirmPassword").css({ "color": "red" });
        } else {
            $("#imageConfirmPassword").removeClass("glyphicon-ok").removeClass("glyphicon-remove").css({"color" : ""});;
            $("#labelConfirmPassword").css({ "color": "black" });
        }
    }
};

function checkSubmit() {
    var current_password = $("input#password").val();
    var new_password = $("input#newPassword").val();
    var confirm_password = $("input#confirmPassword").val();

    if(current_password == 0 || !isValidPassword(current_password))
    {
        $("#title-error").text(msg_current_password_error);
        $("#fix-error").text(msg_current_password_fix);
        $("#dialog-message").dialog("open");
        return false;
    }

    if(new_password == 0 || !isValidPassword(new_password))
    {
        $("#title-error").text(msg_new_password_error);
        $("#fix-error").text(msg_new_password_fix);
        $("#dialog-message").dialog("open");
        return false;
    }

    if(confirm_password == 0 || !isValidPassword(confirm_password))
    {
        $("#title-error").text(msg_confirm_password_error);
        $("#fix-error").text(msg_confirm_password_fix);
        $("#dialog-message").dialog("open");
        return false;
    }

    if(new_password != confirm_password)
    {
        $("#title-error").text(msg_match_password_error);
        $("#fix-error").text(msg_match_password_fix);
        $("#dialog-message").dialog("open");
        return false;
    }

    return true;
}