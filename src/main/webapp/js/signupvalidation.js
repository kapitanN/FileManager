/**
 * Created by Nikita on 08.03.2016.
 */

$(document).ready(function(){
    $("#registrationform").validate({
        rules: {
            firstName:{
                required: true,
                pattern: '^[a-zA-Zа-яА-Я]*$'
            },
            lastName:{
                pattern: '^[a-zA-Zа-яА-Я]*$',
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
                pattern: "Никаких цифр в имени!",
                required: "Поле обязательно для заполения.",
            },
            lastName:{
                pattern: "Никаких цифр в фамилии!",
                required: "Поле обязательно для заполнения.",
            },
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