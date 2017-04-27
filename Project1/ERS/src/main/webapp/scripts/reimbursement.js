$(document).ready(function(){
	$("#app").click(function(){
		$("#app").fadeOut("slow");
		$("#dec").fadeOut("slow");
		$("#stat").fadeOut("slow");
		
		 $.ajax({
	            type: 'post',
	            url: 'app',
	            data: { 
	              'location' : 'action',
	              'action' : 'app'              
	            },
	            success: function (response) {
	            	$("#stat").css("color","#32d811");
           	        $("#stat").text("APPROVED");
           	        $("#stat").fadeIn(2000);
	            }, 
	            error: function (response) {
	            	console.log("error");
	            	$("#app").show();
	        		$("#dec").show();
	            }
		 });
		
		
	});
	
	
	$("#dec").click(function(){
		$("#app").fadeOut("slow");
		$("#dec").fadeOut("slow");
		$("#stat").fadeOut("slow");
		 $.ajax({
	            type: 'post',
	            url: 'app',
	            data: { 
	              'location' : 'action',
	              'action' : 'dec'              
	            },
	            success: function (response) {
	            	$("#stat").css("color","red");
	            	$("#stat").text("DECLINED");
	                $("#stat").fadeIn(2000);
	            }, 
	            error: function (response) {
	            	console.log("error");
	        		$("#app").show();
	        		$("#dec").show();
	            }
		 });
		
		
	});
	
	
	
	
	
	
	
});
