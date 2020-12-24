<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="adminChatApi" value="/api-chat"/>
<c:url var="redirectUrl" value="/admin-chat?id=${USERMODEL.id}"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trò chuyện cùng quản trị</title>
</head>
<body>
	<main>
		<div class="wp-main-content wp-login-page">
			<div class="container">
				
				<div class="login-page">
					<div class="row">
						<div class="col-xl-5 col-lg-5 col-md-6 col-sm-12 col-12">
							<div class="login-txt">
                                <p class="login-txt--branch">EasyAccmod</p>
								<p class="login-txt-des">Nếu có bất cứ vẫn đề gì hãy gửi tin nhắn cho chúng tôi</p>
							</div>
						</div>
						<div class="col-xl-7 col-lg-7 col-md-6 col-sm-12 col-12">
							<div class="wp-chat-form">
								<form action="" id="formSendMsg">
	                                <div class="chat-header">
	                                    <div class="chat-header--name">
	                                        <p>Quản trị</p>
	                                    </div>
	                                    <div class="chat-header--icon-close">
	                                        <i class="fas fa-times"></i>
	                                    </div>
	                                </div>
	                                <div class="chat-body" id="chatBody">
	                                    <div class="content-chat-user" id="chatFrame">
	                                    	<c:forEach var="chat" items="${chats.listResult}">
	                                    		<c:if test="${chat.role == 0}">
	                                    			<div class="msg-sent">
			                                            <p>${chat.content}</p>
			                                        </div>
	                                    		</c:if>
	                                    		<c:if test="${chat.role == 1}">
	                                    			<div class="msg-received">
			                                            <p>${chat.content}</p>
			                                        </div>
	                                    		</c:if>
	                                    	</c:forEach>
	                                    </div>
	                                </div>
	                                <div class="chat-input">
	                                    <input type="text" id="msg-cnt">
	                                    <button type="submit" id="btnSendMsg">Gửi</button>
	                                </div>
	                                <input type="hidden" id="userId" value="${USERMODEL.id }">
	                                <input type="hidden" id="role" value="0">
                                </form>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</main>
	<script src="<c:url value='/template/vendor/jquery-3.5.1.min.js' />"></script>
	<script src="<c:url value='/template/js/scrollend.js' />"></script>
	<script type="text/javascript">
		$('#btnSendMsg').click(function(e){
			e.preventDefault();
			var data = {};
			var formSendMsg = $('#formSendMsg').serializeArray();
			var userId = $('#userId').val();
			var contentMsg = $('#msg-cnt').val();
			var role = $('#role').val();
			formSendMsg.push({name: "content", value: contentMsg});
			formSendMsg.push({name: "role", value: role});
			formSendMsg.push({name: "adminId", value: userId});
			$.each(formSendMsg, function(i, v){
				data[""+v.name+""] = v.value;
			});
			addAdminChat(data);
		})
		function addAdminChat(data){
			$.ajax({
				url: '${adminChatApi}',
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