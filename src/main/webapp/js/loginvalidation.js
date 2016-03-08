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
                required: "Поле обязательно для заполения.",
            },
            password:{
                required: "Поле обязательно для заполнения.",
                minlength: "Пароль должен быть больше пяти символов.",
            },
        }
    });
});