<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
                    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>File Upload to Database</title>
    </head>
    <body>
        <h1>File Upload to Database</h1>
        <form name="fileform" method="post" action="uploadServlet" enctype="multipart/form-data">
            
            <label for="photo"> Portrait Photo:  </label>
            <input type="file" name="photo" size="50" id="imgUp" placeholder="Upload Your Image" required/><br><br>
            <input type="submit" value="Save" onclick="fn()">
        </form>
        <img id="blah" src="#" alt="your image" />
        <img id="getImg" src="#" alt="your image" />
        <button id="submitNewEmp" style="float: left;" onclick="getImgs()">Get img</button>
    </body>
    
    <script>
    function getImgs(){
    	$.post("imgGet", {
			"rid" : 101   //rid goes here
		}, function(result){
			$('#getImg').attr('src', result);
			
		});
    }
    function readURL(input) {

        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
                console.log(e);
                
                $.post("img", {
    				img : e.target.result
    				
    			});
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#imgUp").change(function(){
        readURL(this);
    });
    </script>
</html>