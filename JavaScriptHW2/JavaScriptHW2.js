/* 1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
   
I hope I interpreted this question correctly.
Prints the content of the inner most element that contains USA.
 */

function getUSA() {
	console.log($(':contains("USA"):not(:has(:contains("USA")))').text());
}

/*
 * 2. Sales
 * 
 * Define function getPeopleInSales()
 * 
 * Print the names of all the people in the sales department.
 */
function getPeopleInSales() {
	var result = $('tr:contains("Sales") ');

	for (var i = 0; i < result.length; i++) {
		console.log(result[i].firstChild.nextSibling.innerHTML);
	}

}

/*
 * 3. Click Here
 * 
 * Define function getAnchorChildren()
 * 
 * Find all anchor elements with a <span> child.
 * 
 * Print the contents of <span>
 */
function getAnchorChildren() {

	var result = $('a span');

	for (var i = 0; i < result.length; i++) {
		console.log(result[i].innerHTML);
	}

}

/*
 * 4. Hobbies Define function getHobbies()
 * 
 * Find all checked options in the 'skills' select element.
 * 
 * Print the value and the contents.
 */
function getHobbies() {

	console.log($('select[name=skills] option:selected')[0].innerHTML);
}

/*
 * 5. Custom Attribute
 * 
 * Define function getCustomAttribute()
 * 
 * Find all elements with "data-customAttr" attribute
 * 
 * Print the value of the attribute.
 * 
 * Print the element that has the attribute.
 */
function getCustomAttribute() {

	var result = $('[data-customAttr]');

	for (var i = 0; i < result.length; i++) {
		console.log(result[i].attributes[0].value + " " + result[i].innerHTML);
	}

}

/*
 * 6. Sum Event
 * 
 * NOTE: Write unobtrusive Javascript
 * 
 * Regarding these elements:
 * 
 * <input id="num1" class="nums" type="text"/>
 * 
 * <input id="num2" class="nums" type="text"/>
 * 
 * <h3>Sum: <span id="sum"></span></h3>
 * 
 * 
 * Define onchange event handler.
 * 
 * Add <input> element values.
 * 
 * Put the sum in the <span> element.
 * 
 * If values cannot be added, put "Cannot add" in the <span> element
 */

$(document).ready(
	function() {
	$("#num1, #num2").change(function() {
		if ($.isNumeric($("#num1").val())&& $.isNumeric($("#num2").val())) {
			$("#sum").text(parseInt($("#num1").val())+ parseInt($("#num2").val()));
		} else {
			$("#sum").text("Cannot add");
		}
	});
});

/*
 * 7. Skills Event
 * 
 * NOTE: Write unobtrusive Javascript
 * 
 * When user selects a skill, create an alert with a message similar to:
 * 
 * "Are you sure CSS is one of your skills?"
 * 
 * NOTE: no alert should appear when user deselects a skill.
 */

$(document).ready(
	function() {
		$("select[name=skills]").change(function(){
			alert("Are you sure "+ $("select[name=skills] option:selected").val() + " is one of your skill?");
	});
});

/*
 * 8. Favorite Color Event
 * 
 * NOTE: Write unobtrusive Javascript
 * 
 * NOTE: This is regarding the favoriteColor radio buttons.
 * 
 * When a user selects a color, create an alert with a message similar to:
 * 
 * "So you like green more than blue now?"
 * 
 * In this example, green is the new value and blue is the old value.
 * 
 * Make the background color (of all favoriteColor radio buttons) the newly
 * selected favoriteColor
 */

$(document).ready(function() {
	oldColor = "";
	$("input[name=favoriteColor]").change(function() {
		var newColor = $("input[name=favoriteColor]:checked").val();
		alert("So you like " + newColor + " more than " + oldColor + " now?");
		oldColor = newColor;
	});
});

/*
 * 9. Show/Hide Event
 * 
 * NOTE: Write unobtrusive Javascript
 * 
 * When user hovers over an employees name:
 * 
 * Hide the name if shown. Show the name if hidden.
 */

$(document).ready(function() {
	$(".empName").mouseenter(function() {
		if (!$(this).is(":visible")) {
			$(this).show();
		} else {
			$(this).hide();
		}
	});
});

/*
 * 10. Current Time
 * 
 * Regarding this element: <h5 id="currentTime"></h5>
 * 
 * Show the current time in this element in this format: 9:05:23 AM
 * 
 * The time should be accurate to the second without having to reload the page.
 */
$(document).ready(function() {
	var d = new Date();
	var hours = d.getHours();
	var minutes = d.getMinutes();
	var seconds = d.getSeconds();
	var ampm = hours >= 12 ? 'pm' : 'am';
	hours = hours % 12;
	hours = hours ? hours : 12; 
	minutes = minutes < 10 ? '0' + minutes : minutes;
	var strTime = hours + ':' + minutes + ':' +seconds+' '+ ampm;
	$("#currentTime").text(strTime);
});


/*11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color. */
$(document).ready(function() {
	
	$("#helloWorld").click(function(){
		var duration = 3000;
		setTimeout(function() {
			console.log("df");
			var letters = '0123456789ABCDEF';
		    var color = '#';
		    for (var i = 0; i < 6; i++ ) {
		        color += letters[Math.floor(Math.random() * 16)];
		    }
		    $("#helloWorld").css("background", color);
	    }, duration);
		
	});
});


/*12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).

credit: http://codepen.io/alzobaydee/pen/ietsJ 
*/

function walkTheDOM(node, func){
	
	func(node)
    node = node.firstChild;
      while(node)
      {
          walkTheDOM(node, func);
        node = node.nextSibling;
      }
}


/*walkTheDOM(document.getElementById("body"),
function(node){
alert(node.nodeName + ", " + node.nodeValue);
});*/


