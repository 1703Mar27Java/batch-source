/**
 * 
 */
$(document).ready(function(){
	$("a").on({
		mouseenter:function(){
			$(this).css("color", "red");
		},
		mouseleave:function(){
			$(this).css("color","black");
		}	
		
		});
});


$(document).ready(function(){
		$("p1").click(function(){
			alert("Testing "+$("p1").text("One, Two, Three"));
		});

});


/*
$("#p1").click(function(){
	$(this).text(function(i, origText){
		return "Employee info goes here: "+origText+" And will eventually! ";
	});
	
});*/

/*
$(document).ready(function(){

	var request;  
	function sendInfo()  
	{  
	var v=document.name.username.value;  
	var url="Login.jsp?val="+v;  
	  
	if(window.XMLHttpRequest){  
	request=new XMLHttpRequest();  
	}  
	else if(window.ActiveXObject){  
	request=new ActiveXObject("Microsoft.XMLHTTP");  
	}  
	  
	try{  
	request.onreadystatechange=getInfo;  
	request.open("GET",url,true);  
	request.send();  
	}catch(e){alert("Unable to connect to server");}  
	}  
	  
	function getInfo(){  
	if(request.readyState==4){  
	var val=request.responseText;  
	document.getElementById('out').innerHTML=val;  
	}  
	}  
	
});*/


