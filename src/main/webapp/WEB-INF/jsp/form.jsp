<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form</title>
</head>
<body>
  
<form class="form-horizontal" role="form" id="formSubmit" >
  <label for="fname">First name:</label><br>
  <input type="text" id="fullname" name="fullname" value="John"><br>
  <label for="lname">Last name:</label><br>
  <input type="text" id="sex" name="sex" value="Doe"><br><br>
 <button  type="button" id="btnAddOrUpdateNew">
	Submit
</button>
</form> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$('#btnAddOrUpdateNew').click(function (e) {
	    e.preventDefault(); 
	    var data = {};
	    var formData = $('#formSubmit').serializeArray(); 
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        addNew(data);
	});
	function addNew(data) {
	
		var settings = {
				  "url": "http://localhost:8080/api/document",
				  "method": "POST",
				  "headers": {
				    "Content-Type": "application/json",
				    "Data-Type": "application/octet-stream"
				  },
				  "data": JSON.stringify(data),
				};

				$.ajax(settings).done(function (response) {
	            	window.location.href = "/api/document";
				});
       
	}
</script>
</body>
</html>
