//if (window.console) {
//  console.log("Welcome to your Play application's JavaScript!");
//}


$(document).ready(function(){


//SignUp Button
$('#b1').on("click",function(){
jsRoutes.controllers.HomeController.signUp().ajax({
success: function(data){
$('#MainBody').html(data);

},
error: function(){
$('#MainBody').html("hello");
alert("fail")
}
})
})

//Login Button
$('#b2').on("click",function(){
jsRoutes.controllers.HomeController.signIn().ajax({
success: function(data){
$('#MainBody').html(data);
},
error: function(){
$('#MainBody').html("hello");
alert("fail")
}

})
})

//FormSubmit Button

$('#submitForm').on("click",function(){
jsRoutes.controllers.HomeController.submit($('#name').val(),$('#userName').val(),
                                             $('#password').val(),$('#verifyPassword').val(),$('#mobileNumber').val(),$('#gender').val(),$('#age').val()).ajax({
success: function(data){
$('#MainBody').html(data);
},
error: function(){
$('#MainBody').html("hello");
alert("fail")
}

})
})

//Login Button


$('#login').on("click",function(){
jsRoutes.controllers.HomeController.loginSubmit().ajax({
success: function(data){
$('#MainBody').html(data);
},
error: function(){
$('#MainBody').html("hello");
alert("fail")
}

})
})

$('#home').on("click",function(){
jsRoutes.controllers.HomeController.home().ajax({
success: function(data){
$('#MainBody').html(data);
},
error: function(){
$('#MainBody').html("hello");
alert("fail")
}

})
})



});




