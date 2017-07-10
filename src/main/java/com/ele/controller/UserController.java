package com.ele.controller;

import com.ele.pojo.User;
import com.ele.pojo.UserAddress;
import com.ele.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 返回用户地址
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/profile/address",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getUserAddress(HttpServletRequest req) {
        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
        User user = userService.findById(1);

        List<UserAddress> addressList = user.getAddressList();
        Gson gson = new Gson();
        return gson.toJson(addressList);
    }

    /**
     * 返回要修改的地址信息，并跳转至修改地址界面
     * @param addressId
     * @param req
     * @return
     */
    @RequestMapping(value = "/profile/address/update/{addressId:\\d+}",method = RequestMethod.GET)
    public String updateUserAddress(@PathVariable Integer addressId,HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        boolean isContain = false;
        List<UserAddress> addressList = user.getAddressList();
        for(UserAddress address: addressList) {
            if(address.getId() == addressId) {
                isContain = true;
            }
        }
        //跳转至updateAddress界面(未实现)
        if(isContain) {
            return "server/user/updateAddress";
        } else {
            return "redirect:/profile/address";
        }
    }

    /**
     * 更新用户的地址
     * @param userAddress
     * @param req
     * @return
     */
    @RequestMapping(value = "/profile/address/update/{addressId:\\d+}",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String getUserUpdateAddress(@RequestBody UserAddress userAddress,HttpServletRequest req) {
        userService.updateUserAddress(userAddress);
        return "success";
    }



    /**
     * 用户注册
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String registerUser(@RequestBody User user) {
        if(userService.registUser(user)) {
            return "success";
        } else {
            return "error";
        }
    }



    /**
     * 用户注销
     * @param req
     * @return
     */
    @RequestMapping(value = "/invalidate",method = RequestMethod.GET)
    public String InvalidateUser(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return "server/user/index";
    }

}
