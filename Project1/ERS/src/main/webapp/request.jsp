<%@ include file="includes/head.html"%>
<script type="text/javascript" src="scripts/request.js"></script>
<body>
	<%@ include file="includes/navbar.html"%>
	

	<div class="container" id="requestform">
		<h2>Reimbursement Request</h2>

		<form method="post" name="request" action="app" enctype="multipart/form-data" onsubmit="return validateForm()">
			<input type="hidden" value="request" name = "location"> 
			<div class="form-group">
				<br> <label for="sel0">Amount:</label> $&nbsp;&nbsp;<span
					style="color: red" id="er1"></span><input name="amount" id="sel0" type="text"
					class="form-control"> <br> <label for="sel1">Type:</label>
				<input id="type" name="type" type="hidden" value="Travel">
				<select class="form-control" id="sel1">
					<option>Travel</option>
					<option>Certification</option>
					<option>Material</option>
					<option>Health</option>
					<option>Other</option>
				</select> <br> <label for="sel2">Description:</label>
				<textarea name="description" class="form-control" rows="5" id="comment" ></textarea>
				<br>
				<label for="sel3">Receipt:</label>
				<div id="sel3" class="input-group">

                <label class="input-group-btn">
                    
                    <span class="btn btn-primary">
                       	Browse <input name="receipt" type="file" style="display: none;">
                    </span>
                </label>
                <input id="cfile" type="text" class="form-control" readonly="">
                
            </div>
            
            <input type="submit" style="float:right;margin-top:40px; width:100px; height:40px" class ="btn btn-primary">
            <span id="err" style="color:#ff8787; font-size: 15pt; float:right; margin-top: 50px; margin-right:30px;"></span>
			</div>
		</form>
	</div>


</body>
</html>