<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<header>
	<div class="wp-header">
		<div class="container">
			<div class="row">
				<div class="col-xl-7 col-lg-7 col-md-7 col-sm-6 col-5">
					<div class="wp-menu">
						<ul class="menu-list">
							<li><a href="/easy-accomod-jdbc/trang-chu">Trang chủ</a></li>
						</ul>
					</div>
				</div>
				<div class="col-xl-5 col-lg-5 col-md-5 col-sm-6 col-7">
					<div class="wp-login">
						<ul class="login-list">
							<c:if test="${not empty USERMODEL }">
								<c:if test="${USERMODEL.roleId == 2}">
									<li><a href="<c:url value='/thong-tin-nguoi-dung?id=${USERMODEL.id}'/>">${USERMODEL.fullName}</a></li>
								</c:if>
								<c:if test="${USERMODEL.roleId != 2}">
									<li><a href="#">Xin chào, ${USERMODEL.fullName}</a></li>
								</c:if>
								<li><a href="<c:url value='/thoat?action=logout' />">Thoát</a></li>
							</c:if>
							<c:if test="${empty USERMODEL }">
								<li><a href="<c:url value='/dang-nhap?action=login' />">Đăng nhập</a></li>
								<li><a href="<c:url value='/dang-ky?action=signup' />">Đăng ký</a></li>
							</c:if>
							
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>