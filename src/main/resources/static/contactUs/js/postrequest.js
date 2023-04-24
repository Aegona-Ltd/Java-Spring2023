//$(document).ready(
//		function() {
//
//			// SUBMIT FORM
//			$("#contactForm").submit(function(event) {
//				// Prevent the form from submitting via the browser.
//				event.preventDefault();
//				ajaxPost();
//			});
//
//			function ajaxPost() {
//
//				// PREPARE FORM DATA
//				var formData = {
//
//					name : $("#contactName").val(),
//					email: $("#contactEmail").val(),
//					subject: $("#contactSubject").val(),
//					message: $("#contactMessage").val()
//				}
//
//				// DO POST
//				$.ajax({
//					type : "POST",
//					contentType : "application/json",
//					url : "/saveContact",
//					data : JSON.stringify(formData),
//					dataType : 'json',
//					success : function(result) {
//						if (result.status == "success") {
//							$("#postResultDiv").html(
//									"" + result.data.contactName
//											+ "Post Successfully! <br>"
//											+ "---> Congrats !!" + "</p>");
//						} else {
//							$("#postResultDiv").html("<strong>Error</strong>");
//						}
//						console.log(result);
//					},
//					error : function(e) {
//						alert("Error!")
//						console.log("ERROR: ", e);
//					}
//				});
//
//			}
//
//		}
//		.done(function(data){
//		    console.log(data);
//		});
function check(){
$.ajax({
	type : "POST",
	url : "/saveContact",
	contentType: "application/json; charset=utf-8",
	data : JSON.stringify({
            name : $("#ContactName").val(),
            email: $("#ContactEmail").val(),
            subject: $("#ContactSubject").val(),
            message: $("#ContactMessage").val()
	}),
	dataType : "json",
    encode: null,
})

.done(function (data){
        console.log(data);
});
}