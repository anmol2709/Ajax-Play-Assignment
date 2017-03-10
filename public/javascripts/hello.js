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
alert("No Data Found")
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
alert("No Data Found")

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
alert("No Data Found")
}

})
})

//Login Button


$('#login').on("click",function(){
jsRoutes.controllers.HomeController.loginSubmit($('#userName').val()).ajax({
success: function(data){
$('#MainBody').html(data);
},
error: function(){
alert("No Data Found")
}

})
})


//Home button
$('#home').on("click",function(){
jsRoutes.controllers.HomeController.home().ajax({
success: function(data){
$('#MainBody').html(data);
},
error: function(){
alert("No Data Found")
}
})
})

$('#goToHome').on("click",function(){
jsRoutes.controllers.HomeController.home().ajax({
success: function(data){
$('#MainBody').html(data);
},
error: function(){
alert("No Data Found")
}
})
})

//logout button

$('#logout').on("click",function(){
jsRoutes.controllers.HomeController.logout().ajax({
success: function(data){
$('#MainBody').html(data);
},
error: function(){
alert("No Data Found")
}
})
})

});




