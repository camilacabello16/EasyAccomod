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
						<form id="formSearch" class="form-search" action="<c:url value='/search'/>" method="get">
							<div class="wp-form-search">
								<div class="select-form">
									<label>Loại tin</label>
									<select id="typeRoom">
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
									<select id="streetRoom">
										<option>Tất cả</option>
										<c:forEach var="location" items="${locations.listResult}">
											<option>${location.street}</option>
										</c:forEach>
									</select>
								</div>
								<div class="select-form">
									<label>Khoảng giá</label>
									<select id="priceRoom">
										<option>Chọn mức giá</option>
										<option value="1">Dưới 1 triệu</option>
										<option value="2">1 triệu - 2 triệu</option>
										<option value="3">2 triệu - 3 triệu</option>
										<option value="4">3 triệu - 4 triệu</option>
										<option value="5">4 triệu - 5 triệu</option>
										<option value="6">5 triệu - 6 triệu</option>
										<option value="7">6 triệu - 7 triệu</option>
										<option value="8">7 triệu - 8 triệu</option>
										<option value="9">8 triệu - 9 triệu</option>
										<option value="10">9 triệu - 10 triệu</option>
										<option value="11">Trên 10 triệu</option>
									</select>
								</div>
								<div class="select-form">
									<label>Diện tích</label>
									<select id="areaRoom">
										<option>Chọn diện tích</option>
										<option value="20">Dưới 20m²</option>
										<option value="30">20m² - 30m²</option>
										<option value="40">30m² - 40m²</option>
										<option value="50">40m² - 50m²</option>
										<option value="60">Trên 50m²</option>
									</select>
								</div>
							</div>
							<div class="btn-search">
								<button id="btnSearch" type="submit">Tìm</button>
							</div>
							<input type="hidden" value="" id="type" name="type"/>
							<input type="hidden" value="" id="street" name="street"/>
							<input type="hidden" value="" id="price" name="price"/>
							<input type="hidden" value="" id="area" name="area"/>
						</form>
					</div>
					<div class="wp-room">
						<c:forEach var="room" items="${rooms.listResult }">
							<div class="room-item">
								<div class="room-img">
									<a href="/easy-accomod-jdbc/chi-tiet-phong?id=${room.id}" class="room-img--link">
										<img src="<c:url value='${room.image }'/>">
									</a>
								</div>
								<div class="room-txt">
									<a href="/easy-accomod-jdbc/chi-tiet-phong?id=${room.id}">${room.description}</a>
									<p class="room-txt--price">${room.price} triệu/tháng</p>
									<p class="room-txt--size">${room.area}m²</p>
									<!--  <p class="room-txt--addr">${room.addressId}</p> -->
									<p class="seen-detail">Lượt xem: ${room.seen }</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</main>
	<script src="<c:url value='/template/vendor/jquery-3.5.1.min.js' />"></script>
	<script type="text/javascript">
		$('#btnSearch').click(function(e){
			var typeRoom = $('#typeRoom').val();
			var streetRoom = $('#streetRoom').val();
			var priceRoom = $('#priceRoom').val();
			var areaRoom = $('#areaRoom').val();
			console.log(typeRoom);
			if(streetRoom == "Tất cả"){
				streetRoom = "";
			}
			if(priceRoom == "Chọn mức giá"){
				priceRoom = 11;
			}
			if(areaRoom == "Chọn diện tích"){
				areaRoom = 60;
			}
			//$(function(){
				$('#type').val(typeRoom);
				$('#street').val(streetRoom);
				$('#price').val(priceRoom);
				$('#area').val(areaRoom);
			//})
		})
			
		
		
	</script>
</body>
</html>