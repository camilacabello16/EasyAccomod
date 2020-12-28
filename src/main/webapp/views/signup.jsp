<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="userApi" value="/api-web-user"/>
<c:url var="redirectUrl" value="/dang-nhap?action=login"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<main>
		<div class="wp-main-content wp-login-page">
			<div class="container">
				
				<div class="login-page">
					<div class="row">
						<div class="col-xl-7 col-lg-7 col-md-6 col-sm-12 col-12">
							<div class="login-txt">
								<p class="login-txt--branch">EasyAccmod</p>
								<p class="login-txt-des">Tìm trọ dễ dàng, nhanh chóng và tiện lợi</p>
							</div>
						</div>
						<div class="col-xl-5 col-lg-5 col-md-6 col-sm-12 col-12">
							<div class="wp-login-form">
								<form id="formSignup" name="myform">
									<div class="login-form">
										<div class="login-form--item">
											<input type="text" name="userName" placeholder="Tên người dùng">
										</div>
										<div class="login-form--item">
											<input type="password" name="password" placeholder="Mật khẩu">
										</div>
										<div class="login-form--item">
											<input type="text" name="fullName" placeholder="Họ tên">
										</div>
										<div class="login-form--item">
											<input type="text" name="phone" placeholder="Số điện thoại">
										</div>
									</div>
									<div class="login-form--btn" style="padding-top: 20px;">
										<button type="submit" id="btnSignup">Đăng ký</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</main>
	
	<script src="<c:url value='/template/vendor/jquery-3.5.1.min.js' />"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
    <!--  <script type="text/javascript" src="<c:url value='/template/js/validate.js' />"></script> -->
	<script type="text/javascript">
		$.validator.addMethod("validatePassword", function(value, element) {
	        return this.optional(element) || /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/i.test(value);
	    }, "Hãy nhập password từ 8 đến 16 ký tự bao gồm chữ hoa, chữ thường và ít nhất một chữ số");
        $('#formSignup').validate({
            rules: {
            	userName: "required",
            	fullName: "required",
                phone: "required",
                password: {
                    required: true,
                    validatePassword: true,
                    minlength: 8
                },
                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
            	fullName: "Bạn chưa nhập họ và tên",
                userName: "Bạn chưa nhập tên đăng nhập",
                phone: "bạn chưa nhập số điện thoại",
                password: {
                    required: "Bạn chưa nhập mật khẩu",
                    minlength: "Yêu cầu mật khẩu dài hơn 8 kí tự",
                    validatePassword: "Yêu cầu password từ 8 đến 16 ký tự bao gồm chữ hoa, chữ thường và ít nhất một chữ số"
                },
                email: {
                    required: "Bạn chưa nhập email",
                    email: "Vui lòng nhập đúng email"
                }
            },
            submitHandler: function(form) {
           		var data = {};
    			var formSignup = $('#formSignup').serializeArray();
    			$.each(formSignup, function(i, v){
    				data[""+v.name+""] = v.value;
    			});
    			addUser(data);
    			console.log(data);
	            	
            }
        });
		function addUser(data){
			$.ajax({
				url: '${userApi}',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function (result) {
	            	window.location.href = "${redirectUrl}";
	            },
	            error: function (error) {
	            	console.log(error);
	            }
			});
		}
	</script>
</body>
</html>