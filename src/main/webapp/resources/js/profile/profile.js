/**
 * Created by Admin on 31.07.2015.
 */
$(document).ready(function() {
    $("#dialog-message").attr("title", msg_dialog_title);

    $(function() {
        $( "#dialog-message" ).dialog({
            autoOpen: false,
            modal: true,
            buttons: {
                Ok: function() {
                    $(this).dialog("close");
                }
            }
        });
    });

    $("form").submit(function(event) {
        if(!checkSubmit()){
            event.preventDefault();
        }
    });
});

function isValidPassword(password) {
    //TODO RegExp isValidPassword
    var pattern = new RegExp("");
    return pattern.test(password);
}
