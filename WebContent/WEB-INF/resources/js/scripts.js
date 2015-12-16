$(document).ready(function() {
	$("#btn-registration").click(function() {
		$.ajax({
			url : "registration/validate",
			type : "POST",
			data : {
				username : $('#username').val()
			},
			dataType : "JSON",
			success : function(result) {
				if ($.trim(result) == "true") {
					$('#errors').html('This username is already used!').show();
				} else {
					$('#form-registration').submit();
				}
			},
			error : function() {
				alert('Some error occurred!');
			}
		});
	});
});