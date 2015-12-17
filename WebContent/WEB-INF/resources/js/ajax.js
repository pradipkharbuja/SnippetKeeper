// pathname is contextRoot/path/path/ so we want to get [1] that is where contextRoot is
// [0] has "" as a result of split 
var contextRoot = "/" + window.location.pathname.split('/')[1];

function categorySubmit() {
	var dataToSend = JSON.stringify(serializeObject($('#categoryForm')));
	$.ajax({
		type : 'POST',
		url : contextRoot + '/category/addCategory',
		dataType : "json", // Accepts
		data : dataToSend,
		contentType : 'application/json', // Sends
		success : function() {
			$('#errors').html("");
			$("#result").append('<H3 align="center"> OKAY!! <H3>');
			$('#result').show();
		},

		error : function(errorObject) {
			// error: function(jqXHR, textStatus, HTTPStatus ){
			// error: function(jQuery XMLHttpRequest, "error", "Bad Request" ){

			if (errorObject.responseJSON.errorType == "ValidationError") {
				$('#success').html("");
				$("#errors").append('<H3 align="center"> Error(s)!! <H3>');
				$("#result").append('<p>');

				var errorList = errorObject.responseJSON.errors;
				$.each(errorList, function(i, error) {
					$("#errors").append(error.message + '<br>');
				});
				$("#errors").append('</p>');
				$('#result').show();
			} else {
				alert(errorObject.responseJSON.errors(0)); // "non" Validation
															// Error
			}
		}
	});
}

resetForm = function(id) {
	var element = document.getElementById(id);
	$(element)[0].reset();

}

make_hidden = function(id) {
	var e = document.getElementById(id);
	e.style.display = 'none';
}

make_visible = function(id) {
	var e = document.getElementById(id);
	e.style.display = 'block';
}

// Translate form to array
// Then put in JSON format
function serializeObject(form) {
	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

};