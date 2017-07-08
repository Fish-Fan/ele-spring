package com.ele.controller;


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

        User user = new User();
        user.setUsername("fanyank");
        user.setId(19);

        session.setAttribute("user", user);

        return "home";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String sendMessage(){
        User user = new User();
        user.setUsername("Alice");
        user.setId(20);
        Gson gson = new Gson();

        socketHandler.sendMessageToUser("fanyank", new TextMessage(gson.toJson(user)));

        return "message";
    }
}
