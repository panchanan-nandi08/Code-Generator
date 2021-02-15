
window.onload = function () {
	$("#parsingProgress").hide();
	$("#btnSubmit").click(function (event) {
		event.preventDefault();
		submitGenerteCode();
	});

};

function submitGenerteCode() {
	var form = $("#generateCodeForm")[0];
	var data = new FormData(form);
	$("#btnSubmit").prop("disabled", true);
	$.ajax({
		type: "POST",
		enctype: "multipart/form-data",
		url: '/generateCode',
		data: data,
		dataType: "json",
		processData: false,
		contentType: false,
		cache: false,
		timeout: 600000,
		success: function (data) {
			console.log("SUCCESS : ", data.response);
			swal("Success!", "Code Created Successfully", "success");
			$("#btnSubmit").prop("disabled", false);
			$("#parsingProgress").hide();
		},
		error: function (e) {
			console.log("ERROR : ", e);
			swal("Error!", "Error generating code", "error");
			$("#btnSubmit").prop("disabled", false);
			$("#parsingProgress").hide();
		}
	});

}



