package com.ele.socket;

import com.ele.pojo.ShopManager;
import com.ele.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yanfeng-mac on 2017/7/6.
 */
@Service
public class SocketHandler extends AbstractWebSocketHandler {
    private static final ArrayList<WebSocketSession> users = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println("成功建立起socket链接");
        users.add(webSocketSession);

        String username = webSocketSession.getAttributes().get("shopManager").toString();
        if(username != null) {
            webSocketSession.sendMessage(new TextMessage("我们已经建立起websocket通信啦"));
        }

    }

    @Override
    protected void handleTextMessage(WebSocketSession webSocketSession,TextMessage message) throws Exception {
        System.out.println("handleTextMessage收到消息->" + message.getPayload());
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println("handleMessage收到消息->" + webSocketMessage.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()) {
            webSocketSession.close();
        }

        users.remove(webSocketSession);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        users.remove(webSocketSession);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 跟在线的所用用户发送消息
     * @param textMessage
     */
    public void sendMessageToAllUsers(TextMessage textMessage) {
        for(WebSocketSession webSocketSession : users) {
            if(webSocketSession.isOpen()) {
                try {
                    webSocketSession.sendMessage(textMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 给指定商家发送消息
     * @param shopManager
     * @param textMessage
     */
    public void sendMessageToUser(ShopManager shopManager, TextMessage textMessage) {
        for (WebSocketSession webSocketSession : users) {
            ShopManager shopManager1 = (ShopManager) webSocketSession.getAttributes().get("shopManager");
            if(shopManager1.getPhoneNum().equals(shopManager.getPhoneNum())) {
                try {
                    webSocketSession.sendMessage(textMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            break;
        }
    }
}
