package com.ele.controller;

import com.ele.dto.Goods;
import com.ele.pojo.Shop;
import com.ele.pojo.ShopReward;
import com.ele.service.ShopService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/28.
 */
@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;

    /**
     * 返回商家信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/shop/{id:\\d+}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getShopDetails(@PathVariable Integer id) {
        Shop shop = shopService.findById(id);
        shop.setDiscountDescList(shopService.findDiscountDescById(id));
        shop.setImgList(shopService.findShopImgById(id));

        Gson gson = new Gson();
        return gson.toJson(shop);
    }

    /**
     * 返回商家商品信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/shop/{id:\\d+}/goods",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getShopGoods(@PathVariable Integer id) {
        List<Goods> goodsList = shopService.findShopGoodsById(id);

        Gson gson = new Gson();
        return gson.toJson(goodsList);
    }

    /**
     * 返回商家评论信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/shop/{id:\\d+}/reward",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getShopRewards(@PathVariable Integer id) {
        List<ShopReward> rewardList = shopService.findShopRewardByShopId(id);

        Gson gson = new Gson();
        return gson.toJson(rewardList);
    }


    @RequestMapping(value = "/shop/{id:\\d+}",method = RequestMethod.GET)
    public String demo() {
        return "server/shop/shop";
    }
}
