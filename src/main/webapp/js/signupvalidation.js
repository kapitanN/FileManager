/**
 * Created by Nikita on 08.03.2016.
 */

$(document).ready(function(){
    $("#registrationform").validate({
        rules: {
            firstName:{
                required: true,
                //pattern: '^[a-zA-Zа-яА-Я]*$'
            },
            lastName:{
                //pattern: '^[a-zA-Zа-яА-Я]*$',
                required: true,

            },
            login: {
                required: true,
            },
            password:{
                required: true,
                minlength: 5,
            },
        },
        messages:{
            firstName:{
                pattern: "Must be only letters.",
                required: "Field must be filled.",
            },
            lastName:{
                pattern: "Must be only letters.",
                required: "Field must be filled.",
            },
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