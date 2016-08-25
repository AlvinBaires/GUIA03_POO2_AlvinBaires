$(document).ready(function() {
    //var $form = $("#register-form");
    $("form[data-form-validate='true']").each(function() {
        $(this).validate({
            errorPlacement: function(error, element) {
                // to append radio group validation erro after radio group            
                if (element.is(":radio")) {
                    error.appendTo(element.parents('.form-group'));
                } else {
                    error.insertAfter(element);
                }
                
            }
        });
    })
});