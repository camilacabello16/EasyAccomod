<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="roomApi" value="/api-admin-room"/>
<c:url var="redirectUrl" value="/admin-home"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng phòng</title>
</head>
<body>
	<main>
		<div class="wp-main-content">
			<div class="container">
				<div class="row">
					<div class="wp-form-edit">
						<div class="title-admin">
							<p>Đăng bài cho thuê phòng</p>
						</div>
						<form name="myform" id="formPostRoom">
							<div class="form-edit">
								<div class="form-edit--item">
									<label class="title-form">Tiêu đề</label>
									<div class="txt-validate">
										<input type="text" name="description" value="${rooms.description }">
									</div>
								</div>
								<div class="form-edit--item">
									<p class="title-form">Địa chỉ</p>
									<div class="wp-input">
										<div class="inp-item">
											<label>Đường</label>
											<select name="addrStreet">
												<c:if test="${empty rooms.addrStreet}">
													<option>Chọn đường</option>
													<c:forEach var="addr" items="${addr}">
														<option>${addr.street }</option>
													</c:forEach>
												</c:if>
												<c:if test="${not empty rooms.addrStreet}">
													<option>Chọn đường</option>
													<c:forEach var="addr" items="${addr}">
														<option value="${addr.street}" <c:if test="${addr.street == rooms.addrStreet}">selected="selected"</c:if>>
															${addr.street}
														</option>
													</c:forEach>
												</c:if>
											</select>
										</div>
										<div class="inp-item">
											<label>Quận</label>
											<select>
												<c:if test="${empty rooms.addrDistrict}">
													<option>Chọn quận</option>
													<c:forEach var="addr" items="${addr}">
														<option>${addr.district}</option>
													</c:forEach>
												</c:if>
												<c:if test="${not empty rooms.addrDistrict}">
													<option>Chọn quận</option>
													<c:forEach var="addr" items="${addr}">
														<option value="${addr.district}" <c:if test="${addr.district == rooms.addrDistrict}">selected="selected"</c:if>>
															${addr.district}
														</option>
													</c:forEach>
												</c:if>
											</select>
										</div>
										<div class="inp-item">
											<label>Thành phố</label>
											<select>
												<c:if test="${empty rooms.addrCity}">
													<option>Chọn thành phố</option>
													<c:forEach var="city" items="${cities}">
														<option>${city.city }</option>
													</c:forEach>
												</c:if>
												<c:if test="${not empty rooms.addrCity}">
													<option>Chọn thành phố</option>
													<c:forEach var="city" items="${cities}">
														<option value="${city.city}" <c:if test="${city.city == rooms.addrCity}">selected="selected"</c:if>>
															${city.city }
														</option>
													</c:forEach>
												</c:if>
											</select>
										</div>
									</div>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Loại phòng</label>
									<select name="roomType">
										<c:if test="${empty rooms.roomType}">
											<option>Loại phòng</option>
											<c:forEach var="type" items="${types}">
												<option value="${type.type}">${type.name}</option>
											</c:forEach>
										</c:if>
										<c:if test="${not empty rooms.roomType}">
											<option>Loại phòng</option>
											<c:forEach var="type" items="${types}">		
												<option value="${type.type}" <c:if test="${type.type == rooms.roomType}">selected="selected"</c:if>>
													${type.name}
												</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Giá cả</label>
									<div class="txt-validate">
										<input type="text" name="price" placeholder="Tính theo tháng" value="${rooms.price }">
									</div>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Diện tích</label>
									<div class="txt-validate">
										<input type="number" name="area" placeholder="m²" value="${rooms.area}">
									</div>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Số phòng</label>
									<div class="txt-validate">
										<input type="number" name="numberOfRoom" value="${rooms.numberOfRoom}">
									</div>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Chung chủ</label>
									<select name="owner">
										<option>Có</option>
										<option>Không</option>
									</select>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Phòng tắm</label>
									<select name="bathroom">
										<option>Khép kín</option>
										<option>Chung</option>
									</select>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Phòng bếp</label>
									<select name="kitchen">
										<option>Khu bếp riêng</option>
										<option>Khu bếp chung</option>
										<option>Không nấu ăn</option> 
									</select>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Điều hòa</label>
									<select name="aircondition">
										<option>Có</option>
										<option>Không</option>
									</select>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Ban công</label>
									<select name="bacony">
										<option>Có</option>
										<option>Không</option>
									</select>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Hình ảnh</label>
									<div class="txt-validate">
										<input type="text" name="image" value="${rooms.image }">
									</div>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Trạng thái</label>
									<select name="status">
										<option value="1">Còn phòng</option>
										<option value="0">Hết phòng</option>
									</select>
								</div>
								<div class="form-edit--item">
									<p class="title-form">Thông tin liên hệ</p>
									<div class="info-user">
										<div class="info-user--name">
											<label>Họ tên </label>
											<input type="text" name="" value="${USERMODEL.fullName }">
										</div>
										<div class="info-user--name">
											<label>Số điện thoại </label>
											<input type="text" name="phone" value="${USERMODEL.phone }">
										</div>
									</div>
								</div>
								<div class="wp-btn-update">
									<!--  <button type="submit" name="" id="btnSubmitRoom">Đăng phòng</button> -->
									<input type="submit" id="btnSubmitRoom" value="Đăng phòng">
								</div>
							</div>
							<input type="hidden" id="id" value="${rooms.id}" name="id">
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
	<script src="<c:url value='/template/vendor/jquery-3.5.1.min.js' />"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	<script>
		$(function() {
	        $("#formPostRoom").validate({
	            rules: {
	            	description: "required",
	                apartnumber: "required",
	                street: "required",
	                district: "required",
	                city: "required",
	                describe: "required",
	                price: "required",
	                area: "required",
	                image: "required"
	            },
	            messages: {
	            	description: "Bạn chưa nhập tiêu đề",
	                apartnumber: "Bạn chưa nhập số nhà",
	                street: "Bạn chưa nhập địa chỉ đường",
	                district: "Bạn chưa nhập quận",
	                city: "Bạn chưa nhập thành phố",
	                describe: "Bạn chưa nhập mô tả",
	                price: "Bạn chưa nhập giá cả",
	                area: "Bạn chưa nhập diện tích",
	                image: "Bạn chưa tải hình ảnh"
	                //fullname: "Bạn chưa nhập họ tên",
	                //phonenumber: "Bạn chưa nhập số điện thoại",
	            },
	            submitHandler: function(form) {
	            	//e.preventDefault();
	            	var data = {};
	            	var formData = $('#formPostRoom').serializeArray();
	            	formData.push({name: "seen", value: "0"});
	            	formData.push({name: "rating", value: "5"});
	            	$.each(formData, function(i,v){
	            		data[""+v.name+""] = v.value;
	            	})
	            	console.log(data);
	            	var id = $('#id').val();
	            	if(id == ""){
	            		addRoom(data);
	            	} else{
	            		updateRoom(data);
	            	}
	            }
	        });
	    });
        
        function addRoom(data){
        	$.ajax({
        		url: '${roomApi}',
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
        	})
        }
        function updateRoom(data){
        	$.ajax({
        		url: '${roomApi}',
        		type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                	window.location.href = "${redirectUrl}";
                },
                error: function (error) {
                	console.log(error);
                }
        	})
        }
    </script>
</body>
</html>