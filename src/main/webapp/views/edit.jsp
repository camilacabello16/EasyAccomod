<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
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
						<form name="myform">
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
											<select name="street">
												<option>Chọn đường</option>
												<c:forEach var="addr" items="${addr}">
													<option>${addr.street }</option>
												</c:forEach>
											</select>
										</div>
										<div class="inp-item">
											<label>Quận</label>
											<select name="district">
												<option>Chọn quận</option>
												<c:forEach var="addr" items="${addr}">
													<option>${addr.district}</option>
												</c:forEach>
											</select>
										</div>
										<div class="inp-item">
											<label>Thành phố</label>
											<select name="city">
												<option>Chọn thành phố</option>
												<c:forEach var="city" items="${cities}">
													<option>${city.city }</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Loại phòng</label>
									<select name="roomType">
										<option>Loại phòng</option>
										<c:forEach var="type" items="${types}">
											<option value="${type.type}">${type.name}</option>
										</c:forEach>
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
										<input type="number" name="area" placeholder="m2" value="${rooms.area }">
									</div>
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
									<p class="title-form">Thông tin liên hệ</p>
									<div class="info-user">
										<div class="info-user--name">
											<label>Họ tên </label>
											<input type="text" name="" value="admin">
										</div>
										<div class="info-user--name">
											<label>Số điện thoại </label>
											<input type="text" name="" value="01234">
										</div>
									</div>
								</div>
								<div class="wp-btn-update">
									<button type="submit" name="">Đăng phòng</button>
								</div>
							</div>
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
            $("form[name='myform']").validate({
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
                    form.submit();
                }
            });
        });
    </script>
</body>
</html>