	<div id="footer">
	</div>
</div>
</body>
<script>
$(document).ready(function(){
	setInterval(function(){
		var chour = new Date().getHours();
		if (chour > 12)
			chour -= 12;
		var cmin = new Date().getMinutes();
		if (cmin < 10)
			cmin = '0' + cmin;
		var csec = new Date().getSeconds();
		if (csec < 10)
			csec = '0' + csec;
		$("#currentTime").html(chour + ":" + cmin + ":" + csec 
			+ " " + (new Date().getHours() <= 12 ? 'AM' : 'PM'));
	}, 1000);
})
</script>
</html>