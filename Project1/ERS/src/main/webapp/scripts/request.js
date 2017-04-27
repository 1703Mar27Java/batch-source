$(document).on('change', ':file', function() {
    var input = $(this),
        numFiles = input.get(0).files ? input.get(0).files.length : 1,
        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    input.trigger('fileselect', [numFiles, label]);
});

$(document).ready( function() {
    $(':file').on('fileselect', function(event, numFiles, label) {
        
    	$('#cfile').val(label);
    });
    
    
    $('#sel1').change(function(){
    	$('#type').val($('#sel1').find(":selected").text());
    });
   
});

function validateForm() {
    var amt = document.forms["request"]["amount"].value;
    var type = document.forms["request"]["type"].value;
    var des = document.forms["request"]["description"].value;
    var f = document.forms["request"]["cfile"].value;
    
    if(amt=="" || type=="" || des =="" || f==""){
    	$("#err").text("Fields cannot be blank")
    	return false;
    }
        
}