/**
 * Created by Maxim Sambulat
 */
function isValidPhone(phone) {
    var pattern = new RegExp("^[+]?[0-9]+[-()0-9]{2,18}[0-9]+$");
    return pattern.test(phone);
}

function checkPhone(){
    var phone = $("input#newPhone").val();

    if(phone != 0)
    {
        if(isValidPhone(phone))
        {
            $('#imageValidPhone').removeClass('glyphicon-remove').addClass('glyphicon-ok').css({"color" : "green"});;
            $("#labelNewPhone").css({ "color": "black" });
        } else {
            $("#imageValidPhone").removeClass("glyphicon-ok").addClass("glyphicon-remove").css({"color" : "red"});;
            $("#labelNewPhone").css({ "color": "red" });
        }
    } else {
        $("#imageValidPhone").removeClass("glyphicon-ok").removeClass("glyphicon-remove").css({"color" : ""});;
        $("#labelNewPhone").css({ "color": "black" });
    }
};

function checkSubmit() {
    var phone = $("input#newPhone").val();
    var password = $("input#password").val();

    if(phone == 0 || !isValidPhone(phone)) {
        $("#title-error").text(msg_phone_error);
        $("#fix-error").text(msg_phone_fix);
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