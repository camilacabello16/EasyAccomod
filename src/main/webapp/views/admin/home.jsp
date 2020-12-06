<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<main>
		<div class="wp-main-content">
			<div class="container">
				<div class="row">
					<div class="admin-page">
						<div class="title-admin">
							<p>Danh sách các phòng</p>
						</div>
						<div class="wp-btn-post">
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