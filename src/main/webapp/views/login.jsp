<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
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
								<form action="<c:url value='/dang-nhap' />" method="POST">
									<div class="login-form">
										<div class="login-form--item">
											<input type="text" name="userName" id="userName" placeholder="Tên người dùng">
										</div>
										<div class="login-form--item">
											<input type="password" name="password" id="password" placeholder="Mật khẩu">
										</div>
									</div>
									<c:if test="${not empty message}">
										<p style="color: red;">${message}</p>
									</c:if>
									<input type="hidden" value="login" name="action" />
									<div class="login-form--btn">
										<button type="submit">Đăng nhập</button>
									</div>
									<div class="login-line"></div>
									<div class="regis-btn">
										<a href="#">Đăng ký</a>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</main>
</body>
</html>