package com.ele.controller;

import com.ele.dto.SearchDTO;
import com.ele.pojo.Shop;
import com.ele.pojo.ShopFood;
import com.ele.service.SearchService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/10.
 */
@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    /**
     * 返回搜索到的数据
     * @param searchValue
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/search",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String userSearch(@RequestParam String searchValue) {
        System.out.println("searchValue->" + searchValue);
        List<Shop> shopList = searchService.findShopByLikeName(searchValue);
        List<ShopFood> foodList = searchService.findFoodByLikeName(searchValue);

        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setShopList(shopList);
        searchDTO.setFoodList(foodList);

        Gson gson = new Gson();
        return gson.toJson(searchDTO);
    }


}
