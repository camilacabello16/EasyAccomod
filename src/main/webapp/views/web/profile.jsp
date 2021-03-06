<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="userApi" value="/api-web-user"/>
<c:url var="likeRoomApi" value="/api-like-room"/>
<c:url var="redirectUrl" value="/thong-tin-nguoi-dung?id=${USERMODEL.id}"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin người dùng</title>
</head>
<body>
	<main>
		<div class="wp-profile-page">
			<div class="container">
				<div class="row">
					<div class="title-admin">
						<p>Thông tin người dùng</p>
					</div>
					<div class="profile-user">
						<div class="profile-table">
							<table class="table">
							    <tbody>
							      <tr>
							        <td class="profile-table--title">Tên đăng nhập</td>
							        <td>${user.userName}</td>
							        <td>
							        	<button class="btn-edit-profile" id="editUserName">Sửa</button>
							        </td>
							      </tr>
							      <tr>
							        <td class="profile-table--title">Mật khẩu</td>
							        <td>******</td>
							        <td>
							        	<button class="btn-edit-profile" id="editPass">Sửa</button>
							        </td>
							        
							      </tr>
							      <tr>
							        <td class="profile-table--title">Họ và tên</td>
							        <td>${user.fullName}</td>
							        <td>
							        	<button class="btn-edit-profile" id="editFullName">Sửa</button>
							        </td>
							      </tr>
							      <tr>
							        <td class="profile-table--title">Số điện thoại</td>
							        <td>${user.phone}</td>
							        <td>
							        	<button class="btn-edit-profile" id="editPhoneNb">Sửa</button>
							        </td>
							      </tr>
							    </tbody>
							 </table>
							 <input type="hidden" value="${user.password}" id="oldPassUser"/>
							 <form id="formUpdateUser">
						 		<div class="profile-form-item" id="inpUserName">
						 			<input type="text" placeholder="Nhập tên đăng nhập..." id="updateUserName" value="${user.userName}"/>
						 			<div class="btn-edit-profile" id="closeInpUser">Sửa</div>
						 		</div>
						 		<div class="profile-form-item" id="inpPass">
						 			<input style="margin-bottom: 10px;" type="password" placeholder="Nhập mật khẩu cũ..." id="oldPass" value=""/>
						 			<p id="notMatchPass"></p>
						 			<input type="password" placeholder="Nhập mật khẩu mới..." id="updatePass" value=""/>
						 			<div class="btn-edit-profile" id="closeInpPass">Sửa</div>
						 		</div>
						 		<div class="profile-form-item" id="inpFullName">
						 			<input type="text" placeholder="Nhập họ và tên..." id="updateFullName" value="${user.fullName}"/>
						 			<div class="btn-edit-profile" id="closeInpName">Sửa</div>

						 		</div>
						 		<div class="profile-form-item" id="inpPhoneNb">
						 			<input type="text" placeholder="Nhập số điện thoại..." id="updatePhoneNb" value="${user.phone}"/>
						 			<div class="btn-edit-profile" id="closeInpPhone">Sửa</div>
						 		</div>
						 		<div class="btn-submit-change">
									<button type="submit" id="btnChangeUser">Cập nhật</button>
								</div>
								<input type="hidden" id="roleId" value="2"/>
								<input type="hidden" id="userId" value="${user.id}"/>
							</form>
						</div>
					</div>
					<div class="wp-like-room-list" id="iconLikeList">
						<i class="fas fa-home"></i>
						<p class="nb-like-list">${likeListSize}</p>
						<div class="like-list" id="likeList">
							<c:forEach var="likeList" items="${likeLists.listResult}">
								<div class="like-list-item">
									<c:forEach var="listRoom" items="${listRooms.listResult}">
										<c:if test="${listRoom.id == likeList.roomId }">
											<a href="<c:url value="/chi-tiet-phong?id=${likeList.roomId}"/>" class="like-list-title" id="likeTitle">${listRoom.description}</a>
										</c:if>
									</c:forEach>
									<button type="button" id="btnDeleteLikeRoom">Xóa</button>
									<input type="hidden" value="${likeList.id}" id="likeRoomId">
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="insert-body" id="insertBody"></div>
				</div>
			</div>
		</div>
	</main>
	<script src="<c:url value='/template/vendor/jquery-3.5.1.min.js' />"></script>
	<script src="<c:url value='/template/js/updateUser.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/js/likelist.js'/>"></script>
	<script type="text/javascript">
		$('#btnChangeUser').click(function(e){
			e.preventDefault();
        	var data = {};
        	var formUpdateUser = $('#formUpdateUser').serializeArray();
        	var userName = $('#updateUserName').val();
        	var password = $('#updatePass').val();
        	var fullName = $('#updateFullName').val();
        	var phoneNumber = $('#updatePhoneNb').val();
        	var roleId = $('#roleId').val();
        	var id = $('#userId').val();
        	formUpdateUser.push({name: "roleId", value: roleId});
        	formUpdateUser.push({name: "userName", value: userName});
        	formUpdateUser.push({name: "password", value: password});
        	formUpdateUser.push({name: "fullName", value: fullName});
        	formUpdateUser.push({name: "phone", value: phoneNumber});
        	formUpdateUser.push({name: "id", value: id});
        	$.each(formUpdateUser, function(i, v){
				data[""+v.name+""] = v.value;
			});
        	console.log(data);
        	updateUser(data);
		})
		function updateUser(data){
			$.ajax({
				url: '${userApi}',
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
			});
		}
		$('#btnDeleteLikeRoom').click(function(){
			var data = {};
			var likeRoomId = $('#likeRoomId').val();
			data['id'] = likeRoomId;
			deleteLikeRoom(data);
		})
		function deleteLikeRoom(data){
        	$.ajax({
        		url: '${likeRoomApi}',
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