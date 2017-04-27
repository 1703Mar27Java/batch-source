$(document).ready(function(){
	
	$("#edit").click(function(){
		$("#err").text("");
        $("#change").slideToggle();
        $(this).hide();
        $("#chgpass").hide();
    });
	
	$("#chgpass").click(function(){
		$("#err").text("");
        $("#pass").slideToggle();
        $(this).hide();
        $("#edit").hide();
    });
	
	$("#donepass").click(function(){
		
		var p1 = $("#p1").val(); 
		var p2 = $("#p2").val();
		if(p1 !== p2){
			$("#err").css("color","#f73636")
			$("#err").text("Passwords do not match");
		} else if (p1==="" || p2 ===""){
			$("#err").css("color","#f73636")
			$("#err").text("Fields cannot be blank");			
		} else{
			
			
			 $.ajax({
		            type: 'post',
		            url: 'app',
		            data: { 
		              'location' : 'password',
		              'password': $("#p1").val()
		            },
		            success: function (response) {
		    			$("#err").css("color","white")
		    			$("#err").text("Password successfully changed");
		            	        
		            }
			 });
			 
			 
			$("#pass").slideToggle();
			$("#edit").show();
			$("#chgpass").show();
			 
		}
	});
	
	
    $("#done").click(function(){
    	$("#edit").show();
        $("#change").slideToggle();
        $("#chgpass").show();
        

        $.ajax({
            type: 'post',
            url: 'app',
            data: { 
              'location' : 'user',
              'firstName': $("#firstName").val(), 
              'lastName': $("#lastName").val(),
              'email': $("#email").val()
            },
            success: function (response) {
            	
            	$("#nbfirst").text($("#firstName").val());
            	$("#nblast").text($("#lastName").val());
            	$("#nbemail").text($("#email").val());
            	
            },
            error: function (response) {
            	$("#err").css("color","#f73636")
            	$("#err").text("Email address is already taken");
            }
            
            
         });
		
		
		
    });
    
});