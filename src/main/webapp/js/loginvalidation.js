/**
 * Created by Nikita on 08.03.2016.
 */

$(document).ready(function(){
    $("#loginform").validate({
        rules: {
            login: {
                required: true,
            },
            password:{
                required: true,
                minlength: 5,
            },
            },
        messages:{
            login:{
                required: "Field must be filled.",
            },
            password:{
                required: "Field must be filled.",
                minlength: "Password must be more than 5 characters.",
            },
        }
    });
});