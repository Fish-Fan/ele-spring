package com.ele.controller;

import com.ele.dto.Goods;
import com.ele.pojo.Like;
import com.ele.pojo.Shop;
import com.ele.pojo.ShopReward;
import com.ele.pojo.User;
import com.ele.service.ShopService;
import com.ele.service.UserService;
import com.ele.util.EleUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/28.
 */
@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private UserService userService;
    /**
     * 返回商家信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/shop/{id:\\d+}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getShopDetails(@PathVariable Integer id, HttpServletRequest req) {
        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
        User user = userService.findById(1);

        boolean isLike = EleUtil.userIsLikeShop(user,id,userService);
        Shop shop = shopService.findById(id);
        shop.setDiscountDescList(shopService.findDiscountDescById(id));
        shop.setImgList(shopService.findShopImgById(id));
        shop.setCollectFlag(isLike);
        shop.setLikeCount(shopService.getShopCollectCount(id));
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

    /**
     * 收藏商家
     * @param like
     */
    @ResponseBody
    @RequestMapping(value = "/api/shop/collect",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String UserCollectShop(@RequestBody Like like) {
//        User user = (User) session.getAttribute("user");
        User user = userService.findById(1);

        like.setUserId(user.getId());
        userService.collectShop(like);
        return "success";
    }

    /**
     * 取消收藏商家
     * @param like
     */
    @ResponseBody
    @RequestMapping(value = "/api/shop/uncollect",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String UserUnCollectShop(@RequestBody Like like) {
//        User user = (User) session.getAttribute("user");
        User user = userService.findById(1);

        like.setUserId(user.getId());
        userService.unCollectShop(like);
        return "success";
    }

    /**
     * 商家开店
     * @param shop
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/shop/register")
    public String registerShop(@RequestBody Shop shop) {
        Integer shopId = shopService.insertShop(shop);
        return null;
    }



}
