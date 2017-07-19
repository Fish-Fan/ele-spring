package com.ele.controller;


import com.ele.pojo.ShopManager;
import com.ele.pojo.User;
import com.ele.socket.SocketHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;

/**
 * Created by yanfeng-mac on 2017/7/6.
 */
@Controller
@RequestMapping("/socket")
public class SocketController {
    @Autowired
    private SocketHandler socketHandler;

    @RequestMapping(value="/login")
    public String login(HttpSession session){
        System.out.println("用户登录了建立连接啦");

        ShopManager shopManager = new ShopManager();
        shopManager.setPhoneNum("17888999988");
        shopManager.setShopId(1);
        shopManager.setPassword("123123");

        session.setAttribute("shopManager", shopManager);

        return "order-manage";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String sendMessage(){
        ShopManager shopManager = new ShopManager();
        shopManager.setPhoneNum("17888999988");
        shopManager.setShopId(1);
        shopManager.setPassword("123123");

        Gson gson = new Gson();

        socketHandler.sendMessageToUser(shopManager, new TextMessage(gson.toJson(shopManager)));

        return "message";
    }
}
