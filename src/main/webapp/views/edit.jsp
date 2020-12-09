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
						<form>
							<div class="form-edit">
								<div class="form-edit--item">
									<label class="title-form">Tiêu đề</label>
									<input type="text" name="description">
								</div>
								<div class="form-edit--item">
									<p class="title-form">Địa chỉ</p>
									<div class="wp-input">
										<div class="inp-item">
											<label>Số nhà</label>
											<input type="number" name="">
										</div>
										<div class="inp-item">
											<label>Đường</label>
											<input type="text" name="">
										</div>
										<div class="inp-item">
											<label>Quận</label>
											<input type="text" name="">
										</div>
										<div class="inp-item">
											<label>Thành phố</label>
											<input type="text" name="">
										</div>
									</div>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Loại phòng</label>
									<select name="roomType">
										<option>Phòng trọ</option>
										<option>Chung cư mini</option>
										<option>Nhà nguyên căn</option>
										<option>Chung cư nguyên căn</option>
									</select>
								</div>
								<div class="form-edit--item">
									<label class="title-form">Giá cả</label>
									<input type="text" name="price" placeholder="Tính theo tháng">
								</div>
								<div class="form-edit--item">
									<label class="title-form">Diện tích</label>
									<input type="number" name="area" placeholder="m2">
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
									<input type="button" name="" value="Đăng bài">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>