var active = true;
var check = 0;

$('#oldPass, #oldPassUser').on('keyup', function () {
  if ($('#oldPass').val() == $('#oldPassUser').val()) {
    check = 1;
  } else 
    check = 0;
});

$('#editUserName').click(function(){
	$('#insertBody').addClass("open-notice");
	$('#inpUserName').addClass('display-input-edit');
})
$('#closeInpUser').click(function(){
	$('#insertBody').removeClass("open-notice");
	$('#inpUserName').removeClass('display-input-edit');
	
	
})

$('#editPass').click(function(){
	$('#insertBody').addClass("open-notice");
	$('#inpPass').addClass('display-input-edit');
})
$('#closeInpPass').click(function(){
	if(check == 0){
		$('#notMatchPass').html("Không trùng mật khẩu cũ").css('color', 'red');
	}
	if(check == 1){
		$('#insertBody').removeClass("open-notice");
		$('#inpPass').removeClass('display-input-edit');
	}
})

$('#editFullName').click(function(){
	$('#insertBody').addClass("open-notice");
	$('#inpFullName').addClass('display-input-edit');
})
$('#closeInpName').click(function(){
	$('#insertBody').removeClass("open-notice");
	$('#inpFullName').removeClass('display-input-edit');
})

$('#editPhoneNb').click(function(){
	$('#insertBody').addClass("open-notice");
	$('#inpPhoneNb').addClass('display-input-edit');
})
$('#closeInpPhone').click(function(){
	$('#insertBody').removeClass("open-notice");
	$('#inpPhoneNb').removeClass('display-input-edit');
})