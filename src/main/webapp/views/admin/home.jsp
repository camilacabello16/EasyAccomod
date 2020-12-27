<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="roomApi" value="/api-admin-room"/>
<c:url var="redirectUrl" value="/admin-home"></c:url>
<c:url var="reportApi" value="/api-report"/>
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
								<a href="<c:url value='/admin-home?type=edit' />">Đăng phòng</a>
							</div>
							<div class="btn-delete">
								<button id="btnDelete" type="button">Xóa phòng</button>
							</div>
						</div>
						<div class="admin-room">
							<c:forEach var="room" items="${rooms.listResult }">
								<div class="ad-room-item">
									<div class="ckhbox-del">
										<input type="checkbox" name="" id="checkbox_${room.id}" value="${room.id}">
									</div>
									<div class="wp-ad-room-info">
										<div class="ad-room-info">
											<div class="img-admin-room">
												<img src="<c:url value='${room.image }'/>">
												
											</div>
											<div class="ad-room-txt">
												<p class="ad-room-txt--name">${room.description }</p>
												<p><span>Giá:</span> ${room.price } triệu/tháng</p>
												<c:if test="${room.status == 1 }">
													<p><span>Trạng thái:</span> Còn phòng</p>
												</c:if>
												<c:if test="${room.status == 0 }">
													<p><span>Trạng thái:</span> Hết phòng</p>
												</c:if>
											</div>
										</div>
										<div class="btn-edit-room">
											<c:url var="editUrl" value="/admin-home">
												<c:param name="type" value="edit" />
												<c:param name="id" value="${room.id}" />
											</c:url>
											<a href="${editUrl }">Cập nhật</a>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="admin-page" style="margin-top: 20px;">
						<div class="title-admin">
							<p>Danh sách các phòng có lượt xem nhiều nhất</p>
						</div>
						<div class="admin-room">
							<c:forEach var="room" items="${rooms.listRoom }">
								<div class="ad-room-item">
									<div class="wp-ad-room-info">
										<div class="ad-room-info">
											<div class="img-admin-room">
												<img src="<c:url value='${room.image }'/>">
												
											</div>
											<div class="ad-room-txt">
												<p class="ad-room-txt--name">${room.description }</p>
												<p><span>Giá:</span> ${room.price } triệu/tháng</p>
												<c:if test="${room.status == 1 }">
													<p><span>Trạng thái:</span> Còn phòng</p>
												</c:if>
												<c:if test="${room.status == 0 }">
													<p><span>Trạng thái:</span> Hết phòng</p>
												</c:if>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="wp-icon-bell">
						<div class="icon-bell" id="iconBell">
							<i class="fas fa-bell"></i>
							<p class="nb-notice">${numberReport}</p>
							<div class="wp-list-notice" id="listNotice">
								<c:forEach var="report" items="${reports.listResult }">
									<div class="list-notice">
										<div class="wp-notice-content">
											<a href="<c:url value='/admin-home?type=edit&id=${report.roomId}'/>">Phản hồi của người dùng</a>
											<p class="notice-content">${report.content}</p>
										</div>
										<button type="button" class="btn-del-notice" id="btnDeleteReport">Xóa</button>
										<input type="hidden" id="reportId" value="${report.id}">
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="wp-icon-chatbox" id="iconChatbox">
			<div class="icon-chatbox">
				<a href="<c:url value='/admin-chat?id=${USERMODEL.id}'/>">
					<i class="fas fa-comment-dots"></i>
				</a>
			</div>
		</div>
		<div class="chatbox" id="chatbox">
			<div class="chatbox-header">
				<div class="chatbox-header--name">
					<p>Quản trị</p>
				</div>
				<div class="chatbox-header--icon-close" id="iconClose">
					<i class="fas fa-times"></i>
				</div>
			</div>
			<div class="chatbox-body">
				<div class="content-chat">
					<div class="msg-received">
						<p>Hello</p>
					</div>
					<div class="msg-sent">
						<p>Hello</p>
					</div>
				</div>
			</div>
			<div class="chatbox-input">
				<input type=text>
				<div class="btn-send-msg">
					<i class="fas fa-paper-plane"></i>
				</div>
			</div>
		</div>
	</main>
	<script src="<c:url value='/template/vendor/jquery-3.5.1.min.js' />"></script>
	<script src="<c:url value='/template/js/notice.js' />"></script>
	<script>
		$('#btnDelete').click(function(){
			var data = {};
			var ids = $('input[type=checkbox]:checked').map(function () {
	            return $(this).val();
	        }).get();
			data['ids'] = ids;
			deleteRoom(data);
		})
		function deleteRoom(data){
        	$.ajax({
        		url: '${roomApi}',
        		type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                	window.location.href = "${redirectUrl}";
                },
                error: function (error) {
                	console.log(error);
                }
        	})
        }
		$('#btnDeleteReport').click(function(){
			var data = {};
			var reportid = $('#reportId').val();
			console.log(reportid);
			data['id'] = reportid;
			deleteReport(data);
		})
		function deleteReport(data){
        	$.ajax({
        		url: '${reportApi}',
        		type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
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