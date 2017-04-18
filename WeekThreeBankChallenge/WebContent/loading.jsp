<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<body onload="update()">
<script>
var button;
var count;
var countmax;
var progressbar;
var timerID;

function update() {
	var elem = document.getElementById("bar");
    var width = 10;
    var id = setInterval(frame, 10);
    function frame() {
        if (width >= 100) {
            clearInterval(id);
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4) {
                    var data = xhr.responseText;                
                    window.location.replace("mainPage.jsp");
                }
            }
            xhr.open('GET', 'loginRed', true);
            xhr.send(null);
            
        } else {
            width++;
            elem.style.width = width + '%';
            elem.innerHTML = width * 1 + '%';
        }
    }
}//end function

</script>

</head>
<body>
	<img src="piggyBank.jpg" alt="No graph... sorry">
	<p>The pig says: A penny saved is a penny earned!</p>
	
	<!--make a progress bar-->
	<progress  id="bar" max="1000"></progress> 
	
	<script type="text/javascript">
		//setTimeout ( 'alert(\'Surprise!\')', 5000 );
	</script>
</body>
</html>