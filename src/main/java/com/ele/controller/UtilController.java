package com.ele.controller;

import com.ele.util.QiniuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yanfeng-mac on 2017/7/11.
 */
@Controller
public class UtilController {
    @ResponseBody
    @RequestMapping(value = "/api/util",method = RequestMethod.GET,produces = "application/json;charset-utf-8")
    public String getQiniuToken() {
        String token = QiniuUtil.getDefaultToken();
        System.out.println(token);
        return token;
    }
}
