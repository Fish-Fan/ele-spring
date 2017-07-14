package com.ele.controller;

import com.ele.util.QiniuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yanfeng-mac on 2017/7/11.
 */
@Controller
public class UtilController {
    @ResponseBody
    @RequestMapping(value = "/api/util",method = RequestMethod.GET,produces = "application/json;charset-utf-8")
    public void getQiniuToken(HttpServletRequest req, HttpServletResponse resp) {
        String token = QiniuUtil.getDefaultToken();
        System.out.println(token);
        try {
            PrintWriter out = resp.getWriter();
            out.print("var token = \"" + token + "\"");
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
