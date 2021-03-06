package com.ele.controller;

import com.ele.pojo.Shop;
import com.ele.service.ShopService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/6.
 */
@Controller
public class IndexController {
    @Autowired
    private ShopService shopService;

    /**
     * 获取首页商家信息及活动信息(未做)
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/index/api",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getIndex() {
        List<Shop> shopList = shopService.findBasicShopMsgOrderByServer();
        Gson gson = new Gson();
        return gson.toJson(shopList);
    }

    /**
     * 跳转至首页
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "server/user/index";
    }
}
