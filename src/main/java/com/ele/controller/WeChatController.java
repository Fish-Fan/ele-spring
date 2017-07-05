package com.ele.controller;

import com.ele.pojo.ResponseMsg;
import com.ele.util.WeChatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * Created by yanfeng-mac on 2017/7/4.
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {
    private final String token = "admin";

    public String getToken() {
        return token;
    }

    @ResponseBody
    @RequestMapping(value = "/validate",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public String validate(String signature,String timestamp,String nonce,String echostr) {
        String token = timestamp + nonce + getToken();
        token = WeChatUtil.getSha1(token);
        if(token.equals(signature)) {
            System.out.println("验证通过");
        } else {
            System.out.println("验证失败");
        }
        return echostr;
    }

    @ResponseBody
    @RequestMapping(value = "/validate",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public void getMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String> map = WeChatUtil.xmlToMap(request);

        String userMsg = map.get("Content");

        System.out.println(map);

        PrintWriter out = response.getWriter();

        String result = null;

        if("1".equals(userMsg)) {
            ResponseMsg responseMsg = new ResponseMsg();

            responseMsg.setToUserName(map.get("FromUserName"));
            responseMsg.setFromUserName(map.get("ToUserName"));
            responseMsg.setContent("你欠我1块钱");
            responseMsg.setCreateTime(new Date().toString());
            responseMsg.setMsgType("text");

            result = WeChatUtil.textToXML(responseMsg);
            System.out.println(result);
            out.print(result);
        }

        if("2".equals(userMsg)) {
            ResponseMsg responseMsg = new ResponseMsg();

            responseMsg.setToUserName(map.get("FromUserName"));
            responseMsg.setFromUserName(map.get("ToUserName"));
            responseMsg.setContent("你欠我两块钱");
            responseMsg.setCreateTime(new Date().toString());
            responseMsg.setMsgType("text");

            result = WeChatUtil.textToXML(responseMsg);
            System.out.println(result);
            out.print(result);
        }

        if("给我链接".equals(userMsg)) {
            ResponseMsg responseMsg = new ResponseMsg();

            responseMsg.setToUserName(map.get("FromUserName"));
            responseMsg.setFromUserName(map.get("ToUserName"));
            responseMsg.setContent("<a href='http://fanyank.com/index'>fanyank.com</a>");
            responseMsg.setCreateTime(new Date().toString());
            responseMsg.setMsgType("text");

            result = WeChatUtil.textToXML(responseMsg);
            System.out.println(result);
            out.print(result);
        }


        out.flush();
        out.close();
    }


}
