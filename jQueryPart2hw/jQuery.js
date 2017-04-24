/**
 *This is the .js page for part 2 of the week 4 JavaScript
 *homework assignment 
 */

/*PART II
Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided index.html and as much JQuery and AJAX as possible.
Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.  
Copy the index.html file and rename to: indexJQuery.html
*/

		//TODO: Javascript homework
		/*1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents. 
*/
$(document).ready(function getUSA(){
	$("h1").click(function(){
		alert("This is the: "+$("h1").children().last().html());
	});
});
	
/*2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
$(document).ready(function getPeopleInSales(){
	$("tr").click(function(){
		alert("Salespeople work work work work work.... "+$("tr:nth-child(2)").text()
				+$("tr:nth-child(4)").text()+$("tr:nth-child(6)").text()
				+$("tr:nth-child(7)").text());
	});
});
/*3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>*/
$(document).ready(function getAnchorChildren(){
	$("span").click(function(){
		alert("Everyone gets an A!: "+$("a").text());
	});
});
/*4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.*/
$(document).ready(function getHobbies(){
	$("form").click(function(){
		var $findSelected = $("[selected=selected]")
		alert("What is your hobby?: "+$("[name=skills]").find($findSelected).text());
	//	alert("What is your hobby?: "+$("form").contents().text());
		
	});
});  
/*5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.*/
$(document).ready(function getCustomAttributes(){
	$("body").click(function(){
		var $findCustomAttr = "[data-customAttr]";
		alert("Customized!: "+$("body").find($findCustomAttr ).text());
	
	});
});



 /*6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:	
<input id="num1" class="nums" type="text"/>	
<input id="num2" class="nums" type="text"/>	
<h3>Sum: <span id="sum"></span></h3>
Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
*/
var n1 = document.getElementById("num1");
var n2 = document.getElementById("num2");
var addSum = document.getElementById("sum");

n1.addEventListener("input", add);
n2.addEventListener("input", add);

function add(){
	var one = parseFloat(n1.value) || 0;
	var two = parseFloat(n2.value) || 0;
	
	if(one >=0 ||  two>=0 ==true){
	
	addSum.innerHTML = one + two; }
	else{
		
	 addSum.innerHTML = "Cannot add";}	
		//could not figure out how to make it output
		//cannot add for characters	
}

//original solution:
/*document.getElementById("sum").onchange = function(){
	getSum()
};

function getSum(){
//var n = 0;
var n1=parseInt(document.getElementById("num1").value);
var n2=paseInt(document.getElementById("num2").value);
var sum = document.getElementById("sum").value;

if(n1 + n2 === NaN){
	return sum = element.innterHTML="Cannot add";
}else{
		var sum = document.getElementById("sum").value= n1+n2;}
	}*/


 
 
 
 /*7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:	
"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/

//ran out of time to figure this one out before turning it in
//will continue to work on it on my own
$(document).ready(function(){
	$("form").click(function(){	
		alert("Really dude? Don't lie! "
				+$('[name=skills]').html());
		});
});
/*	

 /*
8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:	
"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor
*/




/*
9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:	
Hide the name if shown.
Show the name if hidden.
*/

$(document).ready(function(){
	$("table").hover(function(){
		$("td:first").hide(); },
		function(){
			$("td:first").show();
			});
});




/*10. Current Time
Regarding this element:
<h5 id="currentTime"></h5>
Show the current time in this element
in this format: 9:05:23 AM
The time should be accurate to the second without
having to reload the page.
 */
  

$(document).ready(function() {
	    function updateClock() {
    var currentTime = new Date();
    var currentHours = currentTime.getHours();
    var currentMinutes = currentTime.getMinutes();
    var currentSeconds = currentTime.getSeconds();
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    var today = mm + '/' + dd + '/' + yyyy ;
    currentMinutes = (currentMinutes < 10 ? "0" : "") + currentMinutes;
    currentSeconds = (currentSeconds < 10 ? "0" : "") + currentSeconds;
    var timeOfDay = (currentHours < 12) ? "AM" : "PM";
    currentHours = (currentHours > 12) ? currentHours - 12 : currentHours;
    currentHours = (currentHours == 0) ? 12 : currentHours;
    var currentTimeString = today + "&nbsp;&nbsp;&nbsp;" + currentHours + ":" + currentMinutes + ":" + currentSeconds + " " + timeOfDay ;
    var currentTimeStringforCheckout = currentHours + ":" + currentMinutes + ":" + currentSeconds + " " + timeOfDay;
    $("h5").html(currentTimeString);
    $(".clock_in_checkout").html(currentTimeStringforCheckout);
}
window.onload = updateClock();
setInterval(function() {
    updateClock();
}, 1000);

}); 
//found solution on: http://stackoverflow.com/questions/16360143/
//time-now-to-update-in-view-without-page-refresh-javascript 
 
 /*11. Delay
Regarding this element:	
<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on 
this element, change the text to a random col
*/
$(document).ready(function(){
	 var colors = ['red','blue', 'green','yellow','purple','pink','black'],
	 color;
		 $("p").click(function(){
		 var randColor;
		 do {
		      randColor = colors[Math.floor(Math.random() * colors.length)];
		    } while (color == randColor);	 
		$("p").css("color", randColor);
		color = randColor;
			 
		 });
		 
	 });
	 
//source:http://stackoverflow.com/questions/32856097/change-background-to-
//random-colors-on-click-javascript-jquery



/*12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. 
Use recursion.
On each node, call func(node).
*/
