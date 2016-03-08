$(document).ready(function() {
    $('#btn').click(function(){
        var name = $('#folderName').val();
        $.ajax({
            type: 'POST',
            data: {folderName : name},
            url: "CreateServlet",
            success: function(result){
                $('#result1').html(result);
            }
        });
    });
});