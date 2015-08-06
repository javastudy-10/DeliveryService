/**
 * Created by Maxim Sambulat
 */
function isValidAddress(address) {
    //TODO RegExp isValidAddress
    var pattern = new RegExp("");
    return pattern.test(address);
}

function checkSubmit() {
    var address = $("input#newAddress").val();
    var password = $("input#password").val();

    if(address == 0 || !isValidAddress(address)) {
        $("#title-error").text(msg_address_error);
        $("#fix-error").text(msg_address_fix);
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