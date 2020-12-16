<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="cmtApi" value="/api-web-comment"/>
<c:url var="redirectUrl" value="/chi-tiet-phong?id=${room.id}"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin phòng</title>
</head>
<body>
	<main>
		<div class="wp-main-content">
			<div class="container">
				<div class="row">
					<div class="room-page">
						<div class="title-room">
							<p>${room.description}</p>
						</div>
						<div class="room-inf">
							<div class="room-inf--img">
								<img src="${room.image }">
							</div>
							<div class="room-inf--detail">
								<div class="room-inf--detail__item">
									<p><span>Địa chỉ: </span>${room.addrDistrict}, ${room.addrCity}</p>
								</div>
								<div class="room-inf--detail__item">
									<c:forEach var="type" items="${types}">
										<c:if test="${type.type == room.roomType }">
											<p><span>Loại phòng: </span>${type.name }</p>
										</c:if>
									</c:forEach>
								</div>
								<div class="room-inf--detail__item">
									<p><span>Ngày cập nhật: </span>${room.createdDate}</p>
								</div>
								<div class="room-inf--detail__item">
									<p><span>Ngày hết hạn: </span>18/11/2020</p>
								</div>
								<div class="room-inf--detail__item">
									<p><span>Người đăng: </span>Đức non nớt</p>
								</div>
								<div class="room-inf--detail__item">
									<p><span>Điện thoại: </span>0123456789</p>
								</div>
								<div class="room-inf--detail__item">
									<p><span>Diện tích: </span>${room.area}</p>
								</div>
								<div class="room-inf--detail__item">
									<p><span>Giá: </span>${room.price} triệu/tháng</p>
								</div>
							</div>
						</div>
						<div class="room-des">
							<div class="room-des--title">
								<p>Thông tin mô tả</p>
							</div>
							<div class="room-des--content">
								<div class="room-des--content__txt">
									<p>- Phòng tắm: ${room.bathroom }</p>
									<p>- Phòng bếp: ${room.kitchen }</p>
									<p>- Điều hòa: ${room.aircondition }</p>
									<p>- Ban công: ${room.bacony }</p>
								</div>
								<div class="login-line"></div>
								<div class="phone-contact">
									<p>Điện thoại liên hệ: </p>
									<a href="">0123456789</a>
								</div>
							</div>
						</div>
						<div class="room-des">
							<div class="wp-user-cmt">
								<div class="room-des--title">
									<p>Bình luận</p>
								</div>
								<div class="user-cmt">
									<c:forEach var="comment" items="${comments.listResult}">
										<div class="user-cmt--item">
											<div class="user-img">
												<i class="fas fa-user"></i>
											</div>
											<div class="wp-cmt-content">
												<div class="user-name">
													<p>${comment.createdBy}</p>
												</div>
												<div class="cmt-content">
													<p>${comment.content}</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
							<div class="add-cmt-user">
								<div class="room-des--title">
									<p>Ý kiến của bạn</p>
								</div>
								<form id="formAddCmt">
									<div class="wp-user-pov">
										<div class="user-pov--cmt">
											<textarea id="content"></textarea>
										</div>
										<div class="user-pov--rate">
											<div class="user-pov--rate__item">
												<input type="radio">
												<label>Rất tệ</label>
											</div>
											<div class="user-pov--rate__item">
												<input type="radio">
												<label>Tệ</label>
											</div>
											<div class="user-pov--rate__item">
												<input type="radio">
												<label>Bình thường</label>
											</div>
											<div class="user-pov--rate__item">
												<input type="radio">
												<label>Tốt</label>
											</div>
											<div class="user-pov--rate__item">
												<input type="radio">
												<label>Rất tốt</label>
											</div>
										</div>
										<div class="btn-post btn-post-cmt">
											<button type="submit" id="btnAddCmt">Gửi</button>
										</div>
									</div>
									<input type="hidden" id="roomId" value="${room.id}">
									<input type="hidden" id="userId" value="${USERMODEL.id }">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	
	<script src="<c:url value='/template/vendor/jquery-3.5.1.min.js' />"></script>
	<script type="text/javascript">
		$('#btnAddCmt').click(function(e){
			e.preventDefault();
			var data = {};
			var formAddCmt = $('#formAddCmt').serializeArray();
			var content = $('#content').val();
			var roomId = $('#roomId').val();
			var userId = $('#userId').val();
			formAddCmt.push({name: "userId", value: userId});
			formAddCmt.push({name: "roomId", value: roomId});
			formAddCmt.push({name: "content", value: content});
			$.each(formAddCmt, function(i, v){
				data[""+v.name+""] = v.value;
			});
			console.log(data);
			console.log(formAddCmt);
			addCmt(data);
		})
		function addCmt(data){
			$.ajax({
				url: '${cmtApi}',
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
			});
		}
	</script>
</body>
</html>