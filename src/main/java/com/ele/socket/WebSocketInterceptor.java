package com.ele.socket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @desp websocket拦截器
 *
 */
public class WebSocketInterceptor implements HandshakeInterceptor{

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler handler, Exception exception) {
		
	}
	
	/**
	 * @desp 将HttpSession中对象放入WebSocketSession中
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
                                   Map<String, Object> map) throws Exception {
		if(request instanceof ServerHttpRequest){
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession();
			if(session!=null){
				//区分socket连接以定向发送消息
				map.put("shopManager", session.getAttribute("shopManager"));
			}
		}
		return true;
	}

}
