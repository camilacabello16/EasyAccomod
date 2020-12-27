$('#iconBell').click(function(){
    $('#listNotice').toggleClass("open-notice");
})

$('#btnReport').click(function(){
	console.log(1);
    $('#insertBody').addClass("open-notice");
	$('#formReport').addClass("open-notice");
})

$('#btnCloseForm').click(function(){
    $('#insertBody').removeClass("open-notice");
	$('#formReport').removeClass("open-notice");
})