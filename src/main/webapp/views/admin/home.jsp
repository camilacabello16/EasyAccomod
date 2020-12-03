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
							<div class="ad-room-item">
								<div class="ckhbox-del">
									<input type="checkbox" name="">
								</div>
								<div class="wp-ad-room-info">
									<div class="ad-room-info">
										<div class="img-admin-room">
											<img src="<c:url value='https://static123.com/phongtro123/uploads/images/thumbs/450x300/fit/2020/11/03/2fa8bbd82e5bd005894a_1604408087.jpg'/>">
											
										</div>
										<div class="ad-room-txt">
											<p class="ad-room-txt--name">CHO THUÊ PHÒNG TRỌ MỚI 100%, PHƯỜNG 9, GÒ VẤP</p>
											<p><span>Giá:</span> 2.5 triệu/tháng</p>
											<p><span>Địa chỉ:</span> Quận Gò Vấp, Hồ Chí Minh</p>
											<p><span>Trạng thái:</span> Còn phòng</p>
										</div>
									</div>
									<div class="btn-edit-room">
										<a href="">Cập nhật</a>
									</div>
								</div>
							</div>
							<div class="ad-room-item">
								<div class="ckhbox-del">
									<input type="checkbox" name="">
								</div>
								<div class="wp-ad-room-info">
									<div class="ad-room-info">
										<div class="img-admin-room">
											<img src="<c:url value='https://static123.com/phongtro123/uploads/images/thumbs/450x300/fit/2020/11/03/2fa8bbd82e5bd005894a_1604408087.jpg'/>">
										</div>
										<div class="ad-room-txt">
											<p class="ad-room-txt--name">CHO THUÊ PHÒNG TRỌ MỚI 100%, PHƯỜNG 9, GÒ VẤP</p>
											<p><span>Giá:</span> 2.5 triệu/tháng</p>
											<p><span>Địa chỉ:</span> Quận Gò Vấp, Hồ Chí Minh</p>
											<p><span>Trạng thái:</span> Còn phòng</p>
										</div>
									</div>
									<div class="btn-edit-room">
										<a href="">Cập nhật</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>