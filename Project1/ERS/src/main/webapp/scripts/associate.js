

$(document).ready(function(){
	
	$(".filter").click(function(){	
		 $('#filtered').text(this.innerHTML+" ");
		 var filter=this.innerHTML.toUpperCase();
		 $('#filtered').append("<span class=\"caret\"></span>");
		 if (filter=="ALL"){
			 $(".table-scroll tr").show();
			 return;
		 }
		 
		 
		 $(".table-scroll").show();
		  var dataset = $('.table-scroll tbody').find('tr');
		  dataset.show();
		  
		  dataset.filter(function(index, item) {
			  console.log($(item).find('td:nth-child(7)').text().trim());
		    return $(item).find('td:nth-child(7)').text().trim().indexOf(filter) === -1;
		  }).hide(); 
	});
	
	
	$("#reimz tbody tr").click(function(){
		$("#rId").val($(this).find("td:first").html());
		$("#viewR").submit();
	});
			
});