<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOM</title>
</head>
<body>
	<div>
		<div>
			<h3>
				Sum: <span id="sum"></span>
			</h3>
			<h5 id="currentTime"></h5>
		</div>
		<div>
			<h1>
				United <span data-customAttr="USA">States</span> of America (<span>USA</span>)
			</h1>
			<div>
				<a>Click Here</a><a>Click Here</a><a>Click Here</a><a>Click Here</a><a>Click
					Here</a>
			</div>
			<a>Click Here</a> <a>Click <span>Here1</span></a> <a>Click Here</a>
			<div>
				<select name="colors">
					<option value="green">Green</option>
					<option value="blue">Blue</option>
					<option value="red" selected="selected">Red</option>
					<option value="purple">Purple</option>
					<option value="yellow" selected="selected">Yellow</option>
				</select>
			</div>
		</div>
		<p id="helloWorld">Hello, World!</p>
		<div>
			<table>
				<tr>
					<th>Name</th>
					<th>Department</th>
				</tr>
				<tr>
					<td class="empName">John</td>
					<td>Sales</td>
				</tr>
				<tr>
					<td class="empName">Amy</td>
					<td>Finance</td>
				</tr>
				<tr>
					<td class="empName">Austin</td>
					<td>Sales</td>
				</tr>
				<tr>
					<td class="empName">Katie</td>
					<td>Marketing</td>
				</tr>
				<tr>
					<td class="empName" data-customAttr="court">Courtney</td>
					<td>Sales</td>
				</tr>
				<tr>
					<td class="empName">Scout</td>
					<td>Sales</td>
				</tr>
			</table>
		</div>
		<form id="firstForm">
			<a>Click <span>Here2</span></a> <input type="text"
				data-customAttr="7" /><br /> <input type="text" data-customAttr="24" /><br />
			<input type="radio" name="favoriteAnimal" value="dog" />Dog<br /> <input
				type="radio" name="favoriteColor" value="blue" />Blue<br /> <input
				id="num1" class="nums" type="text" /><br /> <input type="radio"
				name="favoriteAnimal" value="cat" />Cat<br /> <input type="radio"
				name="favoriteColor" value="red" />Red<br /> <input type="radio"
				name="favoriteAnimal" value="horse" />Horse<br /> <input
				type="radio" name="favoriteAnimal" value="dolphin" />Dolphin<br /> <a>Click
				<span>Here</span>
			</a><br /> <input type="radio" name="favoriteAnimal" value="eagle" />Eagle<br />
			<input type="radio" name="favoriteColor" value="green" />Green<br />
			<input type="radio" name="favoriteColor" value="orange" />Orange<br />
			<select name="hobbies">
				<option value="photography">Photography</option>
				<option value="football" selected="selected">Football</option>
				<option value="kayaking" selected="selected">Kayaking</option>
				<option value="hiking">Hiking</option>
				<option value="programming" selected="selected">Programming</option>
			</select> <input id="num2" class="nums" type="text" /> <select name="skills">
				<option value="java">Java</option>
				<option value="net">.NET</option>
				<option value="dom" selected="selected">DOM</option>
				<option value="html">HTML</option>
				<option value="css">CSS</option>
				<option value="javascript" selected="selected">Javascript</option>
			</select>
		</form>
	</div>
	<a>Click Here</a>
	<a>Click <span data-customAttr="500">Here3</span></a>
	<a>Click Here</a>
	<script type="text/javascript">
		$(document).ready(function(){
			
			function getUSA(){
				
				$("body *").filter(function(){
					var $thi = $(this);
					if($this.children().length==0 && &this.text()=="USA"){
						return $(this.text());
					}
				});
			}
			console.log(getUSA());
			
			function getPeopleInSales(){
				var emps = document.getElementsByClassName("empName");
				for(var i = 0; i<t.length;i++){
					 console.log(t[i).innerHTML);
				}
			}
			
			function getAnchorChildren(){
				$("a").children("span").each(function(index){
					console.log(index+" "+$(this).text());
				}
			}
			getAnchorChildren();
			
			function getHobbies(){
				var hob = $("[name=skills]").children("option:selected");
				for(var i = 0;i<t.length;i++){
					console.log(t[i).innerHTML);
				}
			}
			
			function getCustomAttribute(){
				$("[data-customAttr]").each(function(){
					console.log($(this).attr("data-customAttr"));
					console.log($(this).get(0);
				});
			}
			
			$(".nums").on('change',function(){
				if(!isNaN($('#num1').val()) && !isNaN($('#num2').val())){
					var s1=parseInt($('#num1').val()); 
					var s2=parseInt($('#num2').val()); 
					$('#sum').text(sum1+sum2);
				}
				else{
					$('#sum').text("Cant Add");
				}
			});
			
			$("[name='skills']").change(function(){
				alert("Are you sure"+$(this).children("option:selected").text()+"is one of your skills?");
				
			});
			
			 $(".empName").hover(function(){
 				if($(this).is(":visible")){
 					$(this).hide();
 				}else{
 					$(this).show();
 				}
 			},
 			function(){
 				$(this).show(1000);
 			}
 		 );
			
			
			
			var time = new Date();
			function updateTime() {
				time = new Date();
				
				var seconds = time.getSeconds();
				var mins = time.getMinutes();
				var hours, x;
				if(time.getHours()>12){
					hours=time.getHours()-12;
					x="PM";
				} else {
					hours=time.getHours();
					x="AM";
				}
				$('#currentTime').html(hours+":"+mins+":"+seconds+" "+x);
			}
			$(function() {
				updateTime();
				setInterval(updateTime, 1000);
			});
			
			
			 $("#helloWorld").click(
					function() {
						setTimeout(
							function() {
								var R = Math.floor((Math.random() * 256));
								var G = Math.floor((Math.random() * 256));
								var B = Math.floor((Math.random() * 256));
								$('#helloWorld').css("color", "rgb(" + R + "," + G + "," + B + ")");
							},
							3000);
					}); 
					
			
			function walkTheDOM(n,f)
			{
				func(node);
				$(n).children().each(function($this,f){
						walkTheDOM($(this),f);
						
				});
			}
			
		});
		
		
		
		
	</script>
</body>
</html>