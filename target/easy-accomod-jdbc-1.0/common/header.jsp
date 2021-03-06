<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<header>
	<div class="wp-header">
		<div class="container">
			<div class="row">
				<div class="col-xl-8 col-lg-8 col-md-7 col-sm-6 col-5">
					<div class="wp-menu">
						<ul class="menu-list">
							<li><a href="">Trang chủ</a></li>
						</ul>
					</div>
				</div>
				<div class="col-xl-4 col-lg-4 col-md-5 col-sm-6 col-7">
					<div class="wp-login">
						<ul class="login-list">
							<c:if test="${not empty USERMODEL }">
								<li><a href="#">${USERMODEL.fullName}</a></li>
								<li><a href="<c:url value='/thoat?action=logout' />">Thoát</a></li>
							</c:if>
							<c:if test="${empty USERMODEL }">
								<li><a href="<c:url value='/dang-nhap?action=login' />">Đăng nhập</a></li>
								<li><a href="">Đăng ký</a></li>
							</c:if>
							
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>