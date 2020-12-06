<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EasyAccomod Company</title>
</head>
<body>
	<main>
		<div class="wp-main-content">
			<div class="container">
				<div class="row">
                    <div class="list-account">
                    	<div class="title-admin">
							<p>Danh sách tài khoản</p>
						</div>
                    	<div class="list-acc--table">
							<table class="table">
							    <thead>
							      <tr>
								    <th>
								    	<input type="checkbox" name="">
								    </th>
								    <th>Tên đăng nhập</th>
								    <th>Mật khẩu</th>
								    <th>Tên đầy đủ</th>
								    <th>
								    	Cập nhật
								    </th>
								  </tr>
							    </thead>
							    <tbody>
							    	<c:forEach var="user" items="${users.listResult}">
								      <tr>
									    <td><input type="checkbox" name=""></td>
									    <td>${user.userName }</td>
									    <td>${user.password }</td>
									    <td>${user.fullName }</td>
									    <td><a href="" class="acc-link">Sửa</a></td>
									  </tr>
								  	</c:forEach>
							    </tbody>
							  </table>
						  </div>
						  <div class="wp-btn-post">
							<div class="btn-post">
								<a href="">Thêm tài khoản</a>
							</div>
							<div class="btn-delete">
								<button type="button">Xóa tài khoản</button>
							</div>
						</div>
                    </div>
                    <div class="admin-page company-page">
						<div class="title-admin">
							<p>Danh sách các phòng</p>
						</div>
						<div class="wp-btn-post wp-btn-post-com">
							<div class="btn-post">
								<a href="">Đăng phòng</a>
							</div>
							<div class="btn-delete">
								<button type="button">Xóa phòng</button>
							</div>
						</div>
						<div class="admin-room">
							<c:forEach var="room" items="${rooms.listResult }">
								<div class="ad-room-item">
									<div class="ckhbox-del">
										<input type="checkbox" name="">
									</div>
									<div class="wp-ad-room-info">
										<div class="ad-room-info">
											<div class="img-admin-room">
												<img src="<c:url value='${room.image }'/>">
												
											</div>
											<div class="ad-room-txt">
												<p class="ad-room-txt--name">${room.description }</p>
												<p><span>Giá:</span> ${room.price } triệu/tháng</p>
												<p><span>Địa chỉ:</span> ${room.addressId }</p>
												<c:if test="${room.status == 1 }">
													<p><span>Trạng thái:</span> Còn phòng</p>
												</c:if>
												<c:if test="${room.status == 0 }">
													<p><span>Trạng thái:</span> Hết phòng</p>
												</c:if>
											</div>
										</div>
										<div class="btn-edit-room">
											<a href="">Cập nhật</a>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>