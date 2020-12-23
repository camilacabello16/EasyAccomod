<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                                <div class="chat-header">
                                    <div class="chat-header--name">
                                        <p>Quản trị</p>
                                    </div>
                                    <div class="chat-header--icon-close">
                                        <i class="fas fa-times"></i>
                                    </div>
                                </div>
                                <div class="chat-body">
                                    <div class="content-chat-user" id="chatFrame">
                                        <div class="msg-received">
                                            <p>Hello</p>
                                        </div>
                                        <div class="msg-sent">
                                            <p>Hello</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="chat-input">
                                    <input type="text" id="msg-cnt">
                                    <input type="button" value="send" id="btnSend" onclick="addText()">
                                </div>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</main>
	<script type="text/javascript" src="<c:url value='/template/js/chat.js'/>"></script>
	<script>
     	setInterval(reloaddata, 3000);
    </script>
</body>
</html>