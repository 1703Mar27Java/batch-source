	var filter = "";
	var value= "";

$(document).ready(function(){
	
	$("#reimtab tbody tr").click(function(){
		$("#rId").val($(this).find("td:first").html());
		$("#viewR").submit();
	});
	
	
	$(".filter").click(function(){	
		  $("#reimtab").hide();
		   $("#reimtab").fadeIn("slow");
		 $('#filtered').text(this.innerHTML+" ");
		 var filter=this.innerHTML.toUpperCase();
		 $('#filtered').append("<span class=\"caret\"></span>");
		 
		 
		 $("#reimtab tr").show();		 
		 $("#reimtab").show();
		  var dataset = $('#reimtab tbody').find('tr');
		  dataset.show();
		  
		  if(filter != "ALL"){
		  dataset.filter(function(index, item) {
		    return $(item).find('td:nth-child(7)').text().trim().indexOf(filter) === -1;
		  }).hide(); 
		  }
		  
		  if(value != ""){
		  dataset.filter(function(index, item) {
		    return $(item).find('td:nth-child(6)').text().trim().indexOf(value) === -1;
		  }).hide(); 	
		  }
	});
	
	$("#usertab tbody tr").click(function(){
		 $("#reimtab").hide();
		   $("#reimtab").fadeIn("slow");
			if($(this).hasClass('selected')){  
				value = "";
				$(this).removeClass('selected');
			} else {
				$(this).addClass('selected').siblings().removeClass('selected');    
				   value=$(this).find('td:first').html();	
			}
				
		   
		   $("#reimtab tr").show();	
		   $("#reimtab").show();
			  var dataset = $('#reimtab tbody').find('tr');
			  dataset.show();
			  
			 filter = $('#filtered').text().trim().toUpperCase();
			 console.log(filter);
			  
			  if(value != ""){
				  dataset.filter(function(index, item) {
				    return $(item).find('td:nth-child(6)').text().trim().indexOf(value) === -1;
				  }).hide(); 	
				  }
			  
			  if(filter != "ALL"){
				  console.log("here");
			  dataset.filter(function(index, item) {
			    return $(item).find('td:nth-child(7)').text().trim().indexOf(filter) === -1;
			  }).hide(); 
			  }			
			  
		});
	
	
	
	 $("#newUBtn").click(function(){
		 $(this).hide();
         $("#newU").slideToggle();
     });
	 
	 
	 /* add user ajax call */
	 $("#subuser").click(function(){
		 $("#newU").hide();
		 $("#newUBtn").slideToggle();
		 		 
		 var man;
		 if(document.getElementById('manager').checked) {
			   man ="on";
			} else {
			   man ="off";
			}
		 
		 var username = $("#username").val();
		 var email = $("#email").val();
		 var first = $("#first").val();
		 var last = $("#last").val();
		 
		 if(username==""||email==""||first==""||last==""){
			 var stateTxt = $("#addSuc");
	         
    		 stateTxt.css("color", "red");
    		 stateTxt.text("Fields cannot be empty");
    		 if(stateTxt.is(":visible")) {return; }
    		 stateTxt.fadeIn("slow");
    		 setTimeout(function(){
    			 stateTxt.fadeOut("slow");
    		 }, 5000); 
    		 
    		 return;
		 }
		 
		 $.ajax({
	            type: 'post',
	            url: 'app',
	            data: { 
	              'location' : 'addUser',
	              'username': username,
	              'first': first,
	              'last': last,
	              'email': email,
	              'manager': man
	            },
	            success: function (response) {
	            	var man;
	            	if(man=="on"){
	            		man = "MANAGER";
	            	} else {
	            		man = "ASSOCIATE";
	            	}
	                var user = "<tr><td>"+$("#username").val()+"</td><td>"+$("#first").val()+"</td><td>"+$("#last").val()+"</td><td>"+$("#email").val()+"</td><td>"+man+"</td></tr>"
	            	$("#usertab tbody").append(user);	            	
	            	$("#usertab tbody").hide();
	                $("#usertab tbody").fadeIn("slow");
	            	 var stateTxt = $("#addSuc");
	        		 stateTxt.css("color", "white");
	        		 stateTxt.text($("#username").val() + " successfully added");
	        		 if(stateTxt.is(":visible")) {return; }
	        		 stateTxt.fadeIn("slow");
	        		 setTimeout(function(){
	        			 stateTxt.fadeOut("slow");
	        		 }, 5000);            	        
	            }, 
	            error: function (response) {
	            	//var response = $.parseJSON(xhr.responseText);
	            	 if (response.status==404) {
	                     console.log("404");
	                 } else {
	                	 
	                	 
	                var stateTxt = $("#addSuc");
	         
	        		 stateTxt.css("color", "red");
	        		 stateTxt.text("Email or user already exists");
	        		 if(stateTxt.is(":visible")) {return; }
	        		 stateTxt.fadeIn("slow");
	        		 setTimeout(function(){
	        			 stateTxt.fadeOut("slow");
	        		 }, 5000);    
	        		 
	                 }
	            }
		 });
		 
		 
		
	 });
			
});