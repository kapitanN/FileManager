$(document).ready(function() {
    $('#btn').click(function(event){
        event.preventDefault();
        var name = $('#folderName').val();
        console.log(name);
        $.ajax({
            type: 'POST',
            data: {folderName : name},
            url: "CreateServlet",
            //context: $('#content'),
            success: function(data){
                console.log(data);
                var content = document.getElementById("container-fluid");
                var newForm = document.createElement('form');
                newForm.id = "storage" + name;
                newForm.action = "storage";
                newForm.innerHTML = data;
                content.appendChild(newForm);
                $('#container-fluid').load();
            }
        });
    });
});

//$(document).ready(function() {
//    $('#upload').click(function(event){
//        event.preventDefault();
//       // var data = new FormData('file', $("#file").files);
//        console.log(name);
//        $.ajax({
//            type: 'POST',
//            data:{data : data},
//            url: "UploadServlet",
//            processData: false,
//            contentType: false,
//            //context: $('#content'),
//            success: function(data){
//                console.log(data);
//                var content = document.getElementById("container-fluid");
//                var newForm = document.createElement('form');
//                newForm.id = "storage" + name;
//                newForm.action = "storage";
//                newForm.innerHTML = data;
//                content.appendChild(newForm);
//                $('#container-fluid').load();
//            }
//        });
//    });
//});
//
//$(document).ready(function() {
//    $('#remove').click(function(event){
//        event.preventDefault();
//        var name = $('#{file.name}').val();
//        console.log(name);
//        $.ajax({
//            type: 'POST',
//            data: {name : name},
//            url: "DeleteFolderServlet",
//            //context: $('#content'),
//            success: function(data){
//                console.log(data);
//                var content = document.getElementById("container-fluid");
//                var newForm = document.createElement('form');
//                newForm.id = "storage" + name;
//                newForm.action = "storage";
//                newForm.innerHTML = data;
//                content.appendChild(newForm);
//                $('#container-fluid').load();
//            }
//        });
//    });
//});


//function createFolder(event){
//    event.preventDefault();
//    var folderName = $('#folderName').val();
//    console.log(folderName)
//    //$.get("controller", function(responseText) {
//    //
//    //    testData = responseText;
//    //    console.log(testData);
//    //});
//}