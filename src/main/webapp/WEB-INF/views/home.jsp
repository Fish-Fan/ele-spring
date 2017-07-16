<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String wsPath = "ws://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  This is a WebSocket demo!
	<div id="sendMessage">
		<input type="text" id="sendMessageInput">
		<button id="sendMessgeBtn">发送</button>
	</div>
	<div id="message">
		
	</div>
</h1>

<script type="text/javascript" src="/static/js/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="/static/js/sockjs.js"></script>


<script type="text/javascript">
	
	$(function(){
		//建立socket连接
		var sock;
		if ('WebSocket' in window) {
			sock = new WebSocket("<%=wsPath%>socketServer");
	    } else if ('MozWebSocket' in window) {
	    	sock = new MozWebSocket("<%=wsPath%>socketServer");
	    } else {
	    	sock = new SockJS("<%=basePath%>sockjs/socketServer");
	    }
		sock.onopen = function (e) {
			console.log(e);
			sendMessage("abc");
	    };
	    sock.onmessage = function (e) {
	    	console.log(e)
	        $("#message").append("<p><font color='red'>"+e.data+"</font>")
	    };
	    sock.onerror = function (e) {
	    	console.log(e);
	    };
	    sock.onclose = function (e) {
	    	console.log(e);
	    };

	    $("#sendMessgeBtn").click(function () {
			sendMessage();
        });

	    function sendMessage(message) {
//			var message = $("#sendMessageInput").val();
			console.log("发送消息->" + message);
			sock.send(message);

        }
	});
	
</script>

</body>
</html>
