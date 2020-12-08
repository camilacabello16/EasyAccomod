<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<main>
		<div class="wp-main-content">
			<div class="container">
				<div class="row">
					<div class="wp-search">
						<form class="form-search">
							<div class="wp-form-search">
								<div class="select-form">
									<label>Loại tin</label>
									<select>
										<c:forEach var="type" items="${types.listResult}">
											<option>${type.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="select-form">
									<label>Tỉnh thành</label>
									<select>
										<option>Tất cả</option>
										<c:forEach var="city" items="${cities.listResult}">
											<option>${city.city}</option>
										</c:forEach>
									</select>
								</div>
								<div class="select-form">
									<label>Quận huyện</label>
									<select>
										<option>Tất cả</option>
										<c:forEach var="location" items="${locations.listResult}">
											<option>${location.district}</option>
										</c:forEach>
									</select>
								</div>
								<div class="select-form">
									<label>Đường phố</label>
									<select>
										<option>Tất cả</option>
										<c:forEach var="location" items="${locations.listResult}">
											<option>${location.street}</option>
										</c:forEach>
									</select>
								</div>
								<div class="select-form">
									<label>Khoảng giá</label>
									<select>
										<option>Chọn mức giá</option>
										<option>Dưới 1 triệu</option>
										<option>1 triệu - 2 triệu</option>
										<option>2 triệu - 3 triệu</option>
										<option>3 triệu - 4 triệu</option>
										<option>4 triệu - 5 triệu</option>
										<option>5 triệu - 6 triệu</option>
										<option>6 triệu - 7 triệu</option>
										<option>7 triệu - 8 triệu</option>
										<option>8 triệu - 9 triệu</option>
										<option>9 triệu - 10 triệu</option>
										<option>Trên 10 triệu</option>
									</select>
								</div>
								<div class="select-form">
									<label>Diện tích</label>
									<select>
										<option>Chọn diện tích</option>
										<option>Dưới 20 m²</option>
										<option>20m² - 30m²</option>
										<option>30m² - 40m²</option>
										<option>40m² - 50m²</option>
										<option>Trên 50m²</option>
									</select>
								</div>
							</div>
							<div class="btn-search">
								<button type="submit">Tìm</button>
							</div>
						</form>
					</div>
					<div class="wp-room">
						<c:forEach var="room" items="${rooms.listResult }">
							<div class="room-item">
								<div class="room-img">
									<a href="" class="room-img--link">
										<img src="<c:url value='${room.image }'/>">
									</a>
								</div>
								<div class="room-txt">
									<a href="">${room.description}</a>
									<p class="room-txt--price">${room.price} triệu/tháng</p>
									<p class="room-txt--size">${room.area}m²</p>
									<p class="room-txt--addr">${room.addressId}</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>