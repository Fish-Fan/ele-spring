package com.ele.controller;

import com.ele.pojo.Shop;
import com.ele.service.ShopService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yanfeng-mac on 2017/6/28.
 */
@Controller
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @ResponseBody
    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getShopDetails(@PathVariable Integer id) {
        Shop shop = shopService.findById(id);
        shop.setDiscountDescList(shopService.findDiscountDescById(id));
        shop.setImgList(shopService.findShopImgById(id));
        shop.setGoods(shopService.findShopGoodsById(id));

        Gson gson = new Gson();
        return gson.toJson(shop);
    }
}
